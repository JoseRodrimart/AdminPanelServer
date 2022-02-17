package com.crysec.adminpanelserver.services;


import com.crysec.adminpanelserver.entities.Company;
import com.crysec.adminpanelserver.entities.CryUser;

import java.util.List;

public interface CryUserService {
    public Boolean saveUser(CryUser user);

    void removeCompanyToUser(Long id);

    List<CryUser> getAllUsers();
    CryUser findById(Long id);
}
