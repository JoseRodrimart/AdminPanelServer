package com.crysec.adminpanelserver.services;


import com.crysec.adminpanelserver.entities.Company;
import com.crysec.adminpanelserver.entities.CryUser;

public interface CryUserService {
    public Boolean saveUser(CryUser user);

    void removeCompanyToUser(Long id);
}
