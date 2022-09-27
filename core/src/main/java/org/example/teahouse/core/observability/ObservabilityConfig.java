package org.example.teahouse.core.observability;

import io.micrometer.observation.ObservationRegistry;
import jakarta.servlet.DispatcherType;
import org.example.teahouse.core.actuator.info.RuntimeInfoContributor;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.web.observation.HttpRequestsObservationFilter;

@Configuration
public class ObservabilityConfig {

    // Spring Mvc
    @Bean
    FilterRegistrationBean traceWebFilter(ObservationRegistry observationRegistry) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new HttpRequestsObservationFilter(observationRegistry));
        filterRegistrationBean.setDispatcherTypes(DispatcherType.ASYNC, DispatcherType.ERROR, DispatcherType.FORWARD,
            DispatcherType.INCLUDE, DispatcherType.REQUEST);
        filterRegistrationBean.setOrder(Ordered.LOWEST_PRECEDENCE);
        return filterRegistrationBean;
    }
}