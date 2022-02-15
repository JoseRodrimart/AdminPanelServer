package com.crysec.adminpanelserver.controller;

import com.crysec.adminpanelserver.entities.CryGroup;
import com.crysec.adminpanelserver.services.CryGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

    @Autowired
    CryGroupService groupService;

    @PostMapping("/group")
    public CryGroup createGroup(CryGroup group){

    }

    @PatchMapping("/group/{id}/users")
    public CryGroup insertUserInGroup(@PathVariable Long id, Long userId){
        return groupService.insertUserInGroup();
    }

}
