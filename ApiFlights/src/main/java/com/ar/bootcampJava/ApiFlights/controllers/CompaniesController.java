package com.ar.bootcampJava.ApiFlights.controllers;

import com.ar.bootcampJava.ApiFlights.models.Companies;
import com.ar.bootcampJava.ApiFlights.services.CompaniesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
@Validated
public class CompaniesController {

    @Autowired
    CompaniesService companiesService;

    @CrossOrigin
    @GetMapping(value = "/view")
    public List<Companies> getCompanies(){
        return companiesService.getCompanies();
    }

    @GetMapping(value = "/search/{id}")
    public Optional<Companies> getCompanyById(@PathVariable Long id){
        return companiesService.getCompanyById(id);
    }

    @PostMapping(value = "/create")
    public void createCompany(@Valid @RequestBody Companies company){
        companiesService.createCompany(company);
    }

    @PutMapping(value = "/update/{id}")
    public Companies updateCompany(@PathVariable Long id, @RequestBody Companies company){
        return companiesService.updateCompany(id, company);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteCompany(@PathVariable Long id){
        companiesService.deleteCompany(id);
    }
}
