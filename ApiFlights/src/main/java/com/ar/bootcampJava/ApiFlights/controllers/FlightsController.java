package com.ar.bootcampJava.ApiFlights.controllers;

import com.ar.bootcampJava.ApiFlights.models.Companies;
import com.ar.bootcampJava.ApiFlights.models.Flights;
import com.ar.bootcampJava.ApiFlights.models.FlightsDto;
import com.ar.bootcampJava.ApiFlights.services.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightsController {

    @Autowired
    FlightsService flightsService;

    @GetMapping(value = "/view")
    public List<FlightsDto> getFlights(){
        return flightsService.getFlights();
    }

    @GetMapping(value = "/search/{id}")
    public FlightsDto getFlightById(@PathVariable Long id){
        return flightsService.getFlightById(id);
    }

    @CrossOrigin
    @PostMapping(value = "/create")
    public void createFlight(@RequestBody Flights flight){
        flightsService.createFlight(flight);
    }

    @PutMapping(value = "/update/{id}")
    public Flights updateFlight(@PathVariable Long id, @RequestBody Flights flight){
        return flightsService.updateFlight(id, flight);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteFlight(@PathVariable Long id){
        flightsService.deleteFlight(id);
    }

    @GetMapping("/search/offers")
    public List<FlightsDto> getOffers(){
        Double offerPrice = 800.0;
        return  flightsService.findOffers(offerPrice);
    }

    @GetMapping("search/trip")
    public List<FlightsDto> getFlightsByTrip(@RequestParam String origin, @RequestParam String destination) {
        return flightsService.getByOriginAndDestination(origin, destination);
    }
    @GetMapping("search/byCompany/{company_id}")
    public List<FlightsDto> getFlightsByCompany(@PathVariable Companies company_id) {
        return flightsService.getByCompany(company_id);
    }
}