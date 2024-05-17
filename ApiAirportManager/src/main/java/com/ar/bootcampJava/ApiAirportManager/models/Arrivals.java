package com.ar.bootcampJava.ApiAirportManager.models;

import com.ar.bootcampJava.ApiAirportManager.models.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "arrivals")
@Getter
@Setter
public class Arrivals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long flightId;

    private String origin;

    private LocalDateTime arrivalDateTime;

    private String company;

    private Status status;

    private String gate;

}
