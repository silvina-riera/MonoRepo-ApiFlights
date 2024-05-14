package com.ar.bootcampJava.ApiFlights.services;

import com.ar.bootcampJava.ApiFlights.configuration.FlightsConfiguration;
import com.ar.bootcampJava.ApiFlights.exceptions.ResourceNotExistsException;
import com.ar.bootcampJava.ApiFlights.models.Companies;
import com.ar.bootcampJava.ApiFlights.models.Dollar;
import com.ar.bootcampJava.ApiFlights.models.FlightsDto;
import com.ar.bootcampJava.ApiFlights.repositories.FlightsRepository;
import com.ar.bootcampJava.ApiFlights.models.Flights;
import com.ar.bootcampJava.ApiFlights.utils.FlightsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightsService {

    @Autowired
    FlightsRepository flightsRepository;

    @Autowired
    FlightsUtils flightsUtils;

    @Autowired
    FlightsConfiguration flightsConfiguration;

    public List<FlightsDto> getFlights() {
        List<Flights> flightsList = flightsRepository.findAll();
        return flightsDtoCollector(flightsList);
    }

    public void createFlight(Flights flight) { flightsRepository.save(flight);}

    public FlightsDto getFlightById(Long id){
        Flights flight = flightsRepository.findById(id).orElseThrow(() ->
                new ResourceNotExistsException("El vuelo elegido no existe"));
        return flightsUtils.flightsMapper(flight,getDollar());
    }

    public String deleteFlight(Long id){
        if (flightsRepository.existsById(id)){
            flightsRepository.deleteById(id);
            return "El vuelo con id: " + id + " ha sido eliminado";
        } else {
            throw new ResourceNotExistsException("El vuelo a eliminar elegido no existe");
        }

    }

    public Flights updateFlight(Long id, Flights flight) {
        if (flightsRepository.existsById(id)){
            Flights flightToModify = flightsRepository.findById(id).get();

            if (flight.getOrigin() != null){
                flightToModify.setOrigin(flight.getOrigin());
            }

            if (flight.getDestination() != null){
                flightToModify.setDestination(flight.getDestination());
            }

            if (flight.getDepartureDateTime() != null){
                flightToModify.setDepartureDateTime(flight.getDepartureDateTime());
            }

            if (flight.getArrivalDateTime() != null){
                flightToModify.setArrivalDateTime(flight.getArrivalDateTime());
            }

            if (flight.getPrice() != null){
                flightToModify.setPrice(flight.getPrice());
            }

            if (flight.getFrequence() != null){
                flightToModify.setFrequence(flight.getFrequence());
            }

            if (flight.getCompany() != null){
                flightToModify.setCompany(flight.getCompany());
            }

            Flights flightModified = flightsRepository.save(flightToModify);

            return flightModified;
        }

        return null;
    }

    public  List<FlightsDto> getByOriginAndDestination(String origin, String destination){
        List<Flights> flightsList = flightsRepository.findByOriginAndDestination(origin, destination);
        return flightsDtoCollector(flightsList);
    }

    public  List<FlightsDto> getByCompany(Companies company_id){
        List<Flights> flightsList = flightsRepository.findByCompany(company_id);
        return flightsDtoCollector(flightsList);
    }

    public List<FlightsDto> findOffers(Double offerPrice){
        List<Flights> flightsList = flightsRepository.findAll();
        List<Flights> flightsOffer = flightsUtils.findOffers(flightsList, offerPrice);
        return flightsDtoCollector(flightsOffer);
    }

    private double getDollar() {
        Dollar dollar = flightsConfiguration.fetchDollar();
        return dollar.getAverage();
    }

    private List<FlightsDto> flightsDtoCollector(List<Flights> flightsList) {
        return flightsList.stream()
                .map(flight -> flightsUtils.flightsMapper(flight,getDollar()))
                .collect(Collectors.toList());
    }
}
