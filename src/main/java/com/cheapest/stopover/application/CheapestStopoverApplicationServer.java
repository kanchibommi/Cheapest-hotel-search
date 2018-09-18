package com.cheapest.stopover.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.cheapest.stopover.application" })
@PropertySource({"classpath:application.properties" })
public class CheapestStopoverApplicationServer {

    public static void main(final String[] args) {
        SpringApplication.run(CheapestStopoverApplicationServer.class, args);
    }
}
