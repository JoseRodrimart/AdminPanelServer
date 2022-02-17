package com.crysec.adminpanelserver.controller;

import com.crysec.adminpanelserver.entities.Company;
import com.crysec.adminpanelserver.entities.CryGroup;
import com.crysec.adminpanelserver.entities.CryUser;
import com.crysec.adminpanelserver.exceptions.CompanyNotFoundException;
import com.crysec.adminpanelserver.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;
import java.util.List;

@RestController
public class CompanyController {
    Hashtable<String, String> credentials = new Hashtable<>(){
        {
            put("crysec@mail.com", "crysec");
            put("iespacomolla@mail.com", "iespacomolla");
        }
    };

    @Autowired
    CompanyService companyService;

    /**
     * Get a company by its ID
     *
     *
     * @return the company
     */

    @GetMapping("/login/{mail}/{password}")
    public Long login(@PathVariable String mail, @PathVariable String password){
        if(credentials.containsKey(mail)){
            if(credentials.get(mail).equals(password)){
                if(mail.equals("crysec@mail.com")){
                    return companyService.findByCod("1");
                } else {
                    return companyService.findByCod("2");
                }
            }
        }
        return 0L;
    }

    @GetMapping("/companies")
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }
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
