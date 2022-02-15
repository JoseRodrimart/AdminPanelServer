package com.crysec.adminpanelserver.services;

import com.crysec.adminpanelserver.entities.CryGroup;
import com.crysec.adminpanelserver.repositories.CryGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CryGroupServiceImp implements CryGroupService {
    @Autowired
    CryGroupRepository cryGroupRepository;

    @Override
    public Boolean saveGroup(CryGroup group) {
        try {
            cryGroupRepository.save(group);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
