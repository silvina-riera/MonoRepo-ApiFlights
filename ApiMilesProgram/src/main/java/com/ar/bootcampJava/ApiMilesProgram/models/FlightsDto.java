package com.ar.bootcampJava.ApiMilesProgram.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightsDto {

    private Long id;
    private double convertedPrice;

}
