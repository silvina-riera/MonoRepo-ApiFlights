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

    @GetMapping(value = "/search/{arrivalId}")
    public Optional<Arrivals> getArrivalById(@PathVariable Long arrivalId){
        return arrivalsService.getArrivalById(arrivalId);
    }
    @PostMapping(value = "/create/{flightId}")
    public void createArrival(@PathVariable Long flightId, @RequestBody Arrivals arrival){
        arrivalsService.createArrival(flightId, arrival);
    }

    @PutMapping(value = "/update/{arrivalId}")
    public Arrivals updateArrival(@PathVariable Long arrivalId, @RequestBody Arrivals arrival){
        return arrivalsService.updateArrival(arrivalId, arrival);
    }
    @DeleteMapping(value = "/delete/{arrivalId}")
    public void deleteArrival(@PathVariable Long arrivalId){
        arrivalsService.deleteArrival(arrivalId);
    }

    @GetMapping("/search/byOrigin")
    public List<Arrivals> getByOrigin(@RequestParam String origin) {
        return arrivalsService.getByOrigin(origin);
    }
}
