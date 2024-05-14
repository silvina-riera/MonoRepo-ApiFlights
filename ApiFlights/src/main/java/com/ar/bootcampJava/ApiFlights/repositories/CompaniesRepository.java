package com.ar.bootcampJava.ApiFlights.repositories;

import com.ar.bootcampJava.ApiFlights.models.Companies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniesRepository extends JpaRepository<Companies,Long> {
}
