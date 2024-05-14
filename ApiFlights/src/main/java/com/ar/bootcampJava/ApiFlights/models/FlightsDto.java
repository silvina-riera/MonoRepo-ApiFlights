package com.ar.bootcampJava.ApiFlights.models;

import com.ar.bootcampJava.ApiFlights.models.enums.Frequence;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class FlightsDto {
    private Long id;
    private String origin;
    private String destination;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private double convertedPrice;
    private Frequence frequence;
    private Companies company;

}

