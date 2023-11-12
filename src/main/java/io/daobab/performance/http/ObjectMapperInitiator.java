package io.daobab.performance.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperInitiator {

    public void init() {
        ObjectMapper objectMapper = new ObjectMapper();
    }
}
