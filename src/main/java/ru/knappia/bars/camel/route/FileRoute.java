package ru.knappia.bars.camel.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.apache.camel.util.toolbox.AggregationStrategies;
import org.springframework.stereotype.Component;
import ru.knappia.bars.camel.model.bar.Bar;
import ru.knappia.bars.camel.model.cafe.Cafe;
import ru.knappia.bars.utils.BarMapper;
import ru.knappia.bars.utils.CafeMapper;

import java.util.Optional;

@Component
public class FileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        JacksonDataFormat formatBar = new ListJacksonDataFormat(Bar.class);
        JacksonDataFormat formatCafe = new ListJacksonDataFormat(Cafe.class);

        from("file:{{bars.download}}?noop=true&charset=windows-1251").routeId("Bar route")
                .unmarshal(formatBar)
                .split(body()).streaming()
                    .setBody(exchange -> Optional.of(exchange.getIn().getBody()).map(new BarMapper()).orElseThrow(IllegalArgumentException::new))
                    .to("seda:aggregation?size={{seda.aggregation.size}}&blockWhenFull=true")
                .end()
                .log(LoggingLevel.INFO,"Update Bar complete")
        ;

        from("file:{{cafe.download}}?noop=true&charset=windows-1251").routeId("Cafe route")
                .unmarshal(formatCafe)
                .split(body()).streaming()
                    .setBody(exchange -> Optional.of(exchange.getIn().getBody()).map(new CafeMapper()).orElseThrow(IllegalArgumentException::new))
                    .to("seda:aggregation?size={{seda.aggregation.size}}&blockWhenFull=true")
                .end()
                .log(LoggingLevel.INFO,"Update Cafe complete")
        ;

        from("file:{{restaurants.download}}?noop=true&charset=windows-1251").routeId("Restaurants route")
                .unmarshal(formatCafe)
                .split(body()).streaming()
                    .setBody(exchange -> Optional.of(exchange.getIn().getBody()).map(new CafeMapper()).orElseThrow(IllegalArgumentException::new))
                    .to("seda:aggregation?size={{seda.aggregation.size}}&blockWhenFull=true")
                .end()
                .log(LoggingLevel.INFO,"Update Restaurants complete")
        ;

        from("file:{{coffeehouses.download}}?noop=true&charset=windows-1251").routeId("Coffeehouses route")
                .unmarshal(formatCafe)
                .split(body()).streaming()
                    .setBody(exchange -> Optional.of(exchange.getIn().getBody()).map(new CafeMapper()).orElseThrow(IllegalArgumentException::new))
                    .to("seda:aggregation?size={{seda.aggregation.size}}&blockWhenFull=true")
                .end()
                .log(LoggingLevel.INFO,"Update Coffeehouses complete")
        ;

        from("seda:aggregation?concurrentConsumers={{seda.aggregation.threads}}&size={{seda.aggregation.size}}").routeId("aggregate route")
                .aggregate(constant(true), AggregationStrategies.groupedBody())
                .completionSize(1000)
                .completionTimeout(2000)
                .forceCompletionOnStop()
                    .bean("legalEntityRepository","saveAll");
    }
}
