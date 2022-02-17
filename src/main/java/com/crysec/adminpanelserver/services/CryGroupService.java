package com.crysec.adminpanelserver.services;

import com.crysec.adminpanelserver.entities.CryGroup;
import com.crysec.adminpanelserver.entities.CryUser;

import java.util.List;

public interface CryGroupService {
    public Boolean saveGroup(CryGroup group);

    void insertUserInGroup(Long id, Long userId);

    public List<CryGroup> getAllGroups();

    void updateGroup(CryGroup group);
    public List<CryUser> companyUsersNotIncluded(Long id);
    public void deleteGroupMembers(Long id, Long userId);

    void addGroup(Long idCompany, String name, String type);

    void deleteGroupById(Long id);
}
