package com.ar.bootcampJava.ApiFlights.utils;

import com.ar.bootcampJava.ApiFlights.models.Flights;
import com.ar.bootcampJava.ApiFlights.models.FlightsDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightsUtils {

    public List<Flights> findOffers(List<Flights> flight, double offerPrice) {
        return flight.stream()
                .filter(flights -> flights.getPrice() < offerPrice)
                .collect(Collectors.toList());
    }

    public FlightsDto flightsMapper(Flights flight, double price){
        return new FlightsDto(flight.getId(),flight.getOrigin(), flight.getDestination(), flight.getDepartureDateTime(),
                flight.getArrivalDateTime(), flight.getPrice() * price, flight.getFrequence(), flight.getCompany());
    }

}
