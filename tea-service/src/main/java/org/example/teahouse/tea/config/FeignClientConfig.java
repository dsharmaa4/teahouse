package org.example.teahouse.tea.config;

import feign.Logger;
import feign.Logger.Level;
import feign.micrometer.MicrometerObservationCapability;
import io.micrometer.observation.ObservationRegistry;

import org.springframework.context.annotation.Bean;

// @Configuration is intentionally omitted
public class FeignClientConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Level.BASIC;
    }
}
