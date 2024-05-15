package com.ar.bootcampJava.ApiAirportManager.controllers;

import com.ar.bootcampJava.ApiAirportManager.models.Arrivals;
import com.ar.bootcampJava.ApiAirportManager.services.ArrivalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/arrivals")
public class ArrivalsController {

    @Autowired
    ArrivalsService arrivalsService;

    @GetMapping(value = "/view")
    public List<Arrivals> getArrivals(){
        return arrivalsService.getArrivals();
    }

    @GetMapping(value = "/search/{arrival_id}")
    public Optional<Arrivals> getArrivalById(@PathVariable Long arrival_id){
        return arrivalsService.getArrivalById(arrival_id);
    }
    @PostMapping(value = "/create/{flight_id}")
    public void createArrival(@PathVariable Long flight_id, @RequestBody Arrivals arrival){
        arrivalsService.createArrival(flight_id, arrival);
    }

    @PutMapping(value = "/update/{arrival_id}")
    public Arrivals updateArrival(@PathVariable Long arrival_id, @RequestBody Arrivals arrival){
        return arrivalsService.updateArrival(arrival_id, arrival);
    }
    @DeleteMapping(value = "/delete/{arrival_id}")
    public void deleteArrival(@PathVariable Long arrival_id){
        arrivalsService.deleteArrival(arrival_id);
    }

    @GetMapping("/search/byOrigin")
    public List<Arrivals> getByOrigin(@RequestParam String origin) {
        return arrivalsService.getByOrigin(origin);
    }
}
