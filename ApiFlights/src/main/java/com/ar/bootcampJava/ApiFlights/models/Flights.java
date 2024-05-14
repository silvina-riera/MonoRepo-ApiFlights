package com.ar.bootcampJava.ApiFlights.models;

import com.ar.bootcampJava.ApiFlights.models.enums.Frequence;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@Getter
@Setter
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Debe ingresar el origen del vuelo.")
    @NotBlank(message = "Debe ingresar el origen del vuelo.")
    private String origin;

    @NotNull(message = "Debe ingresar el destino del vuelo.")
    @NotBlank(message = "Debe ingresar el destino del vuelo.")
    private String destination;

    private LocalDateTime departureDateTime;

    private LocalDateTime arrivalDateTime;

    private Double price;

    private Frequence frequence;

    @NotNull(message = "Debe ingresar el ID de la compania.")
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Companies company;
    //Formato del Json: company: {id: }

}
