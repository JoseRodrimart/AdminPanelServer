package com.crysec.adminpanelserver.services;

import com.crysec.adminpanelserver.entities.Company;
import com.crysec.adminpanelserver.entities.CryGroup;

public interface CryGroupService {
    public Boolean saveGroup(CryGroup group);

    void insertUserInGroup();
}
