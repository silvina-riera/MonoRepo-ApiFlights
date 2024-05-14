package com.ar.bootcampJava.ApiFlights.repositories;

import com.ar.bootcampJava.ApiFlights.models.Companies;
import com.ar.bootcampJava.ApiFlights.models.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightsRepository extends JpaRepository<Flights,Long> {

    List<Flights> findByOriginAndDestination(String origin, String destination);

    List<Flights> findByCompany(Companies company_id);
}