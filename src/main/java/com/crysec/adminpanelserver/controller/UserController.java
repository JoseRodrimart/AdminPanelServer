package com.crysec.adminpanelserver.controller;

import com.crysec.adminpanelserver.services.CryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    CryUserService userService;

    @DeleteMapping("/user/{id}/company")
    public void removeUserFromCompany(@PathVariable Long id){
        userService.removeCompanyToUser(id);
    }

}
