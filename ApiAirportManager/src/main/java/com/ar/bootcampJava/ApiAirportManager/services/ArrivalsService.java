package com.ar.bootcampJava.ApiAirportManager.services;

import com.ar.bootcampJava.ApiAirportManager.exceptions.ResourceNotExistsException;
import com.ar.bootcampJava.ApiAirportManager.models.Arrivals;
import com.ar.bootcampJava.ApiAirportManager.models.FlightsDto;
import com.ar.bootcampJava.ApiAirportManager.repositories.ArrivalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArrivalsService {

    @Autowired
    ArrivalsRepository arrivalsRepository;

    @Autowired
    FlightsClient flightsClient;


    public List<Arrivals> getArrivals() {
        return arrivalsRepository.findAll();
    }

    public void createArrival(Long flight_id, Arrivals arrival) {

        FlightsDto flight = flightsClient.getFlightById(flight_id);

        arrival.setFlight_id(flight.getId());
        arrival.setOrigin(flight.getOrigin());
        arrival.setArrivalDateTime(flight.getArrivalDateTime());
        arrival.setCompany(flight.getCompany().getName());

        arrivalsRepository.save(arrival);}

    public Optional<Arrivals> getArrivalById(Long arrival_id) {
        return arrivalsRepository.findById(arrival_id);
    }

    public String deleteArrival(Long arrival_id){
        if (arrivalsRepository.existsById(arrival_id)){
            arrivalsRepository.deleteById(arrival_id);
            return "El arribo con id: " + arrival_id + " ha sido eliminado";
        } else {
            throw new ResourceNotExistsException("El arribo a eliminar elegido no existe");
        }

    }

    public Arrivals updateArrival(Long arrival_id, Arrivals arrival) {
        if (arrivalsRepository.existsById(arrival_id)){
            Arrivals arrivalToModify = arrivalsRepository.findById(arrival_id).get();

            if (arrival.getArrivalDateTime() != null){
                arrivalToModify.setArrivalDateTime(arrival.getArrivalDateTime());
            }

            if (arrival.getStatus() != null){
                arrivalToModify.setStatus(arrival.getStatus());
            }

            if (arrival.getGate() != null){
                arrivalToModify.setGate(arrival.getGate());
            }

            Arrivals arrivalModified = arrivalsRepository.save(arrivalToModify);

            return arrivalModified;
        }

        return null;
    }

    public  List<Arrivals> getByOrigin(String origin){
        return arrivalsRepository.findByOrigin(origin);
    }

}


