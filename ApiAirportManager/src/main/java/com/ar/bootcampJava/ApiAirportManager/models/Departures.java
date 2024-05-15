package com.ar.bootcampJava.ApiAirportManager.models;

import com.ar.bootcampJava.ApiAirportManager.models.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Debe ingresar un vuelo.")
    @NotBlank(message = "Debe ingresar un vuelo.")
    private Long flight_id;

    private String destination;

    private LocalDateTime departureDateTime;

    private String company;

    @NotNull(message = "Debe ingresar el estado del vuelo.")
    @NotBlank(message = "Debe ingresar el estado del vuelo.")
    private Status status;

    private String gate;

}