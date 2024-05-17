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

    public void createArrival(Long flightId, Arrivals arrival) {

        FlightsDto flight = flightsClient.getFlightById(flightId);

        arrival.setFlightId(flight.getId());
        arrival.setOrigin(flight.getOrigin());
        arrival.setArrivalDateTime(flight.getArrivalDateTime());
        arrival.setCompany(flight.getCompany().getName());

        arrivalsRepository.save(arrival);}

    public Optional<Arrivals> getArrivalById(Long arrivalId) {
        return arrivalsRepository.findById(arrivalId);
    }

    public String deleteArrival(Long arrivalId){
        if (arrivalsRepository.existsById(arrivalId)){
            arrivalsRepository.deleteById(arrivalId);
            return "El arribo con id: " + arrivalId + " ha sido eliminado";
        } else {
            throw new ResourceNotExistsException("El arribo a eliminar elegido no existe");
        }

    }

    public Arrivals updateArrival(Long arrivalId, Arrivals arrival) {
        if (arrivalsRepository.existsById(arrivalId)){
            Arrivals arrivalToModify = arrivalsRepository.findById(arrivalId).get();

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


