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

    @GetMapping(value = "/search/{departure_id}")
    public Optional<Departures> getDepartureById(@PathVariable Long departure_id){
        return departuresService.getDepartureById(departure_id);
    }
    @PostMapping(value = "/create/{flight_id}")
    public void createDeparture(@PathVariable Long flight_id, @RequestBody Departures departure){
        departuresService.createDeparture(flight_id, departure);
    }

    @PutMapping(value = "/update/{departure_id}")
    public Departures updateDeparture(@PathVariable Long departure_id, @RequestBody Departures departure){
        return departuresService.updateDeparture(departure_id, departure);
    }
    @DeleteMapping(value = "/delete/{departure_id}")
    public void deleteDeparture(@PathVariable Long departure_id){
        departuresService.deleteDeparture(departure_id);
    }

    @GetMapping("/search/byDestination")
    public List<Departures> getByDestination(@RequestParam String destination) {
        return departuresService.getByDestination(destination);
    }
}
