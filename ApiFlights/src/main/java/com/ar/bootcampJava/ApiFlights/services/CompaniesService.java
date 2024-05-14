package com.ar.bootcampJava.ApiFlights.services;

import com.ar.bootcampJava.ApiFlights.exceptions.ResourceNotExistsException;
import com.ar.bootcampJava.ApiFlights.models.Companies;
import com.ar.bootcampJava.ApiFlights.repositories.CompaniesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompaniesService {

    @Autowired
    CompaniesRepository companiesRepository;

    public List<Companies> getCompanies() {
        return companiesRepository.findAll();
    }

    public void createCompany(Companies company) {
        companiesRepository.save(company);
    }

    public Optional<Companies> getCompanyById(Long id) {
        return companiesRepository.findById(id);
    }

    public String deleteCompany(Long id){
        if (companiesRepository.existsById(id)){
            companiesRepository.deleteById(id);
            return "La compania con id: " + id + " ha sido eliminada";
        } else {
            throw new ResourceNotExistsException("La compania a eliminar elegida no existe");
        }

    }

    public Companies updateCompany(Long id, Companies company) {
        if (companiesRepository.existsById(id)){
            Companies companyToModify = companiesRepository.findById(id).get();

            if (company.getName() != null){
                companyToModify.setName(company.getName());
            }

            if (company.getBanner() != null){
                companyToModify.setBanner(company.getBanner());
            }

            Companies companyModified = companiesRepository.save(companyToModify);

            return companyModified;
        }

        return null;
    }
}

