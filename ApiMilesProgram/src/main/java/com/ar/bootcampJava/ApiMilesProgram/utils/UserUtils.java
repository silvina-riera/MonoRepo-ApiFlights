package com.ar.bootcampJava.ApiMilesProgram.utils;

import org.springframework.stereotype.Component;

@Component
public class UserUtils {

    public double getPointsEarned (double price) {
        return price * 0.2;
    }
}
