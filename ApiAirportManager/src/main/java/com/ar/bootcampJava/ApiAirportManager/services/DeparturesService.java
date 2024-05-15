package com.ar.bootcampJava.ApiAirportManager.services;

import com.ar.bootcampJava.ApiAirportManager.exceptions.ResourceNotExistsException;
import com.ar.bootcampJava.ApiAirportManager.models.Departures;
import com.ar.bootcampJava.ApiAirportManager.models.FlightsDto;
import com.ar.bootcampJava.ApiAirportManager.repositories.DeparturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeparturesService {


    @Autowired
    DeparturesRepository departuresRepository;

    @Autowired
    FlightsClient flightsClient;


    public List<Departures> getDepartures() {
        return departuresRepository.findAll();
    }

    public void createDeparture(Long flight_id, Departures departure) {

        FlightsDto flight = flightsClient.getFlightById(flight_id);

        departure.setFlight_id(flight.getId());
        departure.setDestination(flight.getDestination());
        departure.setDepartureDateTime(flight.getDepartureDateTime());
        departure.setCompany(flight.getCompany().getName());

        departuresRepository.save(departure);}

    public Optional<Departures> getDepartureById(Long departure_id) {
        return departuresRepository.findById(departure_id);
    }

    public String deleteDeparture(Long departure_id){
        if (departuresRepository.existsById(departure_id)){
            departuresRepository.deleteById(departure_id);
            return "La partida con id: " + departure_id + " ha sido eliminada";
        } else {
            throw new ResourceNotExistsException("La partida a eliminar elegida no existe");
        }

    }

    public Departures updateDeparture(Long departure_id, Departures departure) {
        if (departuresRepository.existsById(departure_id)){
            Departures departureToModify = departuresRepository.findById(departure_id).get();

            if (departure.getDepartureDateTime() != null){
                departureToModify.setDepartureDateTime(departure.getDepartureDateTime());
            }

            if (departure.getStatus() != null){
                departureToModify.setStatus(departure.getStatus());
            }

            if (departure.getGate() != null){
                departureToModify.setGate(departure.getGate());
            }

            Departures departureModified = departuresRepository.save(departureToModify);

            return departureModified;
        }

        return null;
    }

    public  List<Departures> getByDestination(String destination){
        return departuresRepository.findByDestination(destination);
    }
}
