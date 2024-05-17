package com.ar.bootcampJava.ApiAirportManager.controllers;

import com.ar.bootcampJava.ApiAirportManager.models.Departures;
import com.ar.bootcampJava.ApiAirportManager.services.DeparturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departures")
public class DeparturesController {


    @Autowired
    DeparturesService departuresService;

    @GetMapping(value = "/view")
    public List<Departures> getDepartures(){
        return departuresService.getDepartures();
    }

    @GetMapping(value = "/search/{departureId}")
    public Optional<Departures> getDepartureById(@PathVariable Long departureId){
        return departuresService.getDepartureById(departureId);
    }
    @PostMapping(value = "/create/{flightId}")
    public void createDeparture(@PathVariable Long flightId, @RequestBody Departures departure){
        departuresService.createDeparture(flightId, departure);
    }

    @PutMapping(value = "/update/{departureId}")
    public Departures updateDeparture(@PathVariable Long departureId, @RequestBody Departures departure){
        return departuresService.updateDeparture(departureId, departure);
    }
    @DeleteMapping(value = "/delete/{departureId}")
    public void deleteDeparture(@PathVariable Long departureId){
        departuresService.deleteDeparture(departureId);
    }

    @GetMapping("/search/byDestination")
    public List<Departures> getByDestination(@RequestParam String destination) {
        return departuresService.getByDestination(destination);
    }
}
