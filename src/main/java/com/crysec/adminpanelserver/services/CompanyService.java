package com.crysec.adminpanelserver.services;

import com.crysec.adminpanelserver.entities.Company;
import com.crysec.adminpanelserver.entities.CryGroup;
import com.crysec.adminpanelserver.entities.CryUser;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    public Boolean saveCompany(Company company);

    Optional<Company> findByName(String name);

    Optional<Company> findById(Long id);

    List<CryUser> getUsers(Long id);

    List<CryGroup> getGroups(Long id);
}
