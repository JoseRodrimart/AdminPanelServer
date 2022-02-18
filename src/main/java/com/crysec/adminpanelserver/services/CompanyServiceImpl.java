package com.crysec.adminpanelserver.services;

import com.crysec.adminpanelserver.entities.Company;
import com.crysec.adminpanelserver.entities.CryGroup;
import com.crysec.adminpanelserver.entities.CryUser;
import com.crysec.adminpanelserver.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CompanyServiceImpl implements  CompanyService{

    @Autowired CompanyRepository companyRepository;

    @Override
    public Boolean saveCompany(Company company) {
        try {
            companyRepository.save(company);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<Company> findByName(String name) {
        return companyRepository.findByName(name);
    }

    @Override
    public Optional<Company> findById(Long id) {
return companyRepository.findById(id);
    }

    @Override
    public List<CryUser> getUsers(Long id) {
        return companyRepository.findUsers(id);
    }

    @Override
    public List<CryGroup> getGroups(Long id) {
        return companyRepository.findGroups(id);
    }

    @Override
    public Long findByCod(String cod) {
        return companyRepository.findByCod(cod).get();
    }
}
