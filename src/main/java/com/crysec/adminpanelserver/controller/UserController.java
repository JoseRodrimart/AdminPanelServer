package com.crysec.adminpanelserver.controller;

import com.crysec.adminpanelserver.entities.CryUser;
import com.crysec.adminpanelserver.services.CryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    CryUserService userService;

    @DeleteMapping("/user/{id}/company")
    public void removeUserFromCompany(@PathVariable Long id){
        userService.removeCompanyToUser(id);
    }


    @GetMapping("/user")
    public List<CryUser> cryUser(){
        return userService.getAllUsers();
    }
    @PostMapping("/user/hello")
    public void hello(){
        System.out.println("HOLA, bienvenido");
    }
}
