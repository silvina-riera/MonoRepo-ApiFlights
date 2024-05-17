package com.ar.bootcampJava.ApiMilesProgram.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull(message = "Debe ingresar un nombre.")
    @NotBlank(message = "Debe ingresar un nombre.")
    private String passengerName;

    private String passengerEmail;

    @NotNull(message = "Debe ingresar el pasaporte.")
    @NotBlank(message = "Debe ingresar el pasaporte.")
    private String passengerPassport;

    private BigDecimal points;

}
