package com.crysec.adminpanelserver.services;

import com.crysec.adminpanelserver.entities.CryUser;
import com.crysec.adminpanelserver.exceptions.UserNotFoundException;
import com.crysec.adminpanelserver.repositories.CryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CryUserServiceImpl implements CryUserService{
    @Autowired
    CryUserRepository cryUserRepository;

    @Override
    public Boolean saveUser(CryUser user) {
        try {
            cryUserRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public void removeCompanyToUser(Long id) {
        CryUser user = cryUserRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
        user.setCompany(null);
        //cryUserRepository.save(user);
    }
}
