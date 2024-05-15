package com.ar.bootcampJava.ApiAirportManager.controllers;

import com.ar.bootcampJava.ApiAirportManager.models.FlightsDto;
import com.ar.bootcampJava.ApiAirportManager.services.FlightsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/arrivals/flights")
public class FlightsController {

    @Autowired
    FlightsClient flightsClient;

    @GetMapping(value = "/view")
    public List<FlightsDto> getFlights(){
        return flightsClient.getFlights();
    }

    @GetMapping(value = "/search/{flight_id}")
    public FlightsDto getFlightById(@PathVariable Long flight_id){
        return flightsClient.getFlightById(flight_id);
    }
}
