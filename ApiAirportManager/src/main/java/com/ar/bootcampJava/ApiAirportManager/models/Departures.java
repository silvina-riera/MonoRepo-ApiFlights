package com.ar.bootcampJava.ApiAirportManager.models;

import com.ar.bootcampJava.ApiAirportManager.models.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "departures")
@Getter
@Setter
public class Departures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long flight_id;

    private String destination;

    private LocalDateTime departureDateTime;

    private String company;

    private Status status;

    private String gate;

}
