package com.ar.bootcampJava.ApiFlights.configuration;

import com.ar.bootcampJava.ApiFlights.models.Dollar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FlightsConfiguration {

    @Value("${dollar.apiUrl}")
    public String DOLLAR_VALUE;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public Dollar fetchDollar(){
        RestTemplate restTemplate = restTemplate();
        return restTemplate.getForObject(DOLLAR_VALUE, Dollar.class);
    }

}
