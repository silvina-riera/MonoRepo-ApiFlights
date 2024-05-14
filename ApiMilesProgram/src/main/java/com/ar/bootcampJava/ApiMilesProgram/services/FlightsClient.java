package com.ar.bootcampJava.ApiMilesProgram.services;

import com.ar.bootcampJava.ApiMilesProgram.models.FlightsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "flights-server")
public interface FlightsClient {
    @GetMapping("/api/flights/view")
    List<FlightsDto> getFlights();

    @GetMapping("/api/flights/search/{id}")
    FlightsDto getFlightById(@PathVariable Long id);

}
