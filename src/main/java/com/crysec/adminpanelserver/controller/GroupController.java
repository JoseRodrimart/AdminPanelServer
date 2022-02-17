package com.crysec.adminpanelserver.controller;

import com.crysec.adminpanelserver.entities.CryGroup;
import com.crysec.adminpanelserver.entities.CryUser;
import com.crysec.adminpanelserver.services.CryGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {

    @Autowired
    CryGroupService groupService;

    @PostMapping("/group/{idCompany}/{name}/{type}")
    public void createGroup(@PathVariable Long idCompany, @PathVariable String name, @PathVariable String type){
        System.out.println("************************************************************");
        groupService.addGroup(idCompany, name, type);
    }

    @DeleteMapping("/group/{id}")
    public void deleteGroup(@PathVariable Long id){
        System.out.println("***************************************");
        groupService.deleteGroupById(id);
    }


    @GetMapping("/group")
    public List<CryGroup> getAllGroups(){
        return groupService.getAllGroups();
    }

    @PutMapping("/group")
    public void updateCompany(@RequestBody CryGroup group){
        System.out.println(group);
        groupService.updateGroup(group);
    }
    @GetMapping("/group/{id}/companyusersnotincluded")
    public List<CryUser> getNotMembersUsers(@PathVariable Long id) {
        System.out.println("petición" + id);
        return groupService.companyUsersNotIncluded(id);
    }
    @DeleteMapping("/group/{id}/user/{userId}")
    public void deleteGroupMember(@PathVariable Long id, @PathVariable Long userId){
        groupService.deleteGroupMembers(id, userId);
    }
    @PutMapping("/group/{id}/user/{userId}")
    public void addMemberToGroup(@PathVariable Long id, @PathVariable Long userId){
        groupService.insertUserInGroup(id, userId);
    }

}
