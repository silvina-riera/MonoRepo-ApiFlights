package com.ar.bootcampJava.ApiAirportManager.repositories;

import com.ar.bootcampJava.ApiAirportManager.models.Arrivals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArrivalsRepository extends JpaRepository<Arrivals, Long> {

    List<Arrivals> findByOrigin(String origin);
}
