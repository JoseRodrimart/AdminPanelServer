package com.crysec.adminpanelserver.controller;

import com.crysec.adminpanelserver.entities.Company;
import com.crysec.adminpanelserver.entities.CryGroup;
import com.crysec.adminpanelserver.entities.CryUser;
import com.crysec.adminpanelserver.exceptions.CompanyNotFoundException;
import com.crysec.adminpanelserver.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    CompanyService companyService;

    /**
     * Get a company by its ID
     *
     * @param id the id
     * @return the company
     */

    @GetMapping("/company/{id}")
    public Company getCompany(@PathVariable Long id){
        return companyService.findById(id).orElseThrow(() -> new CompanyNotFoundException(id));
    }

    @GetMapping("/company/name/{name}")
    public Company getCompanyByName(@PathVariable String name){
        return companyService.findByName(name).orElseThrow(() -> new CompanyNotFoundException(name));
    }

    @GetMapping("/company/{id}/user")
    public List<CryUser> getCompanyUsers(@PathVariable Long id){
        return companyService.getUsers(id);
    }

    @GetMapping("/company/{id}/group")
    public List<CryGroup>  getCompanyGroups(@PathVariable Long id){ return companyService.getGroups(id);}
}
