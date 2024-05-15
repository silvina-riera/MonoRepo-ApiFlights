package com.ar.bootcampJava.ApiAirportManager.repositories;

import com.ar.bootcampJava.ApiAirportManager.models.Departures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeparturesRepository extends JpaRepository<Departures, Long> {

    List<Departures> findByDestination(String destination);
}
