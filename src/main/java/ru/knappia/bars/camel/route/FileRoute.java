package ru.knappia.bars.camel.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.apache.camel.util.toolbox.AggregationStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.knappia.bars.camel.model.Bar;
import ru.knappia.bars.repository.BarEntityRepository;
import ru.knappia.bars.utils.BarMapper;

import java.util.Optional;

@Component
public class FileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        JacksonDataFormat format = new ListJacksonDataFormat(Bar.class);

        from("file:{{bars.download}}?noop=true&charset=windows-1251")
                .unmarshal(format)
                .split(body()).streaming()
                .setBody(exchange -> Optional.of(exchange.getIn().getBody()).map(new BarMapper()).orElseThrow(IllegalArgumentException::new))
//                .aggregate().constant(true)
                .bean("barEntityRepository","save")
        ;
    }
}
