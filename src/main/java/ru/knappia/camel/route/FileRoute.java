package ru.knappia.camel.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.stereotype.Component;
import ru.knappia.camel.model.Bar;

@Component
public class FileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        JacksonDataFormat format = new ListJacksonDataFormat(Bar.class);

        from("file:{{bars.download}}?noop=true&charset=utf-8")
                .unmarshal(format)
                .split(body()).streaming()
                .log(LoggingLevel.INFO, body().toString())
        ;
    }
}
