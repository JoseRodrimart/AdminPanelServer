package com.crysec.adminpanelserver.services;

import com.crysec.adminpanelserver.entities.CryGroup;
import com.crysec.adminpanelserver.entities.CryUser;
import com.crysec.adminpanelserver.repositories.CryGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CryGroupServiceImp implements CryGroupService {
    @Autowired
    CryGroupRepository cryGroupRepository;
    @Autowired
    CompanyServiceImpl companyService;
    @Autowired
    CryUserServiceImpl userService;

    @Override
    public Boolean saveGroup(CryGroup group) {
        try {
            cryGroupRepository.save(group);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    @Override
    public void insertUserInGroup(Long id, Long userId) {
        CryGroup group = cryGroupRepository.findById(id).get();
        CryUser user = userService.findById(userId);
        group.addRegularUser(user);
    }

    @Override
    public List<CryGroup> getAllGroups() {
        return cryGroupRepository.findAll();
    }

    @Transactional
    @Override
    public void updateGroup(CryGroup group) {
        CryGroup editingGroup = cryGroupRepository.findById(group.getId()).get();
        editingGroup.setName(group.getName());
        editingGroup.setType(group.getType());

    }

    @Override
    public List<CryUser> companyUsersNotIncluded(Long id) {

        var grupo = cryGroupRepository.findById(id).get();

        var empresa = grupo.getCompany().getId();

        var companyUsers = companyService.getUsers(empresa);

        var groupUsers = grupo.getRegularUsers();

        ArrayList<Long> includedIndexes = new ArrayList<>();

        groupUsers.forEach(x -> includedIndexes.add(x.getId()));

        return companyUsers.stream().filter(x->{
            if(includedIndexes.contains(x.getId())) return false;
            else return true;
        }).collect(Collectors.toList());

    }

    @Transactional
    @Override
    public void deleteGroupMembers(Long id, Long userId) {
        var group = cryGroupRepository.findById(id);
        var user = userService.findById(userId);
        if(group.isPresent()){
            group.get().getRegularUsers().remove(user);
        } else {
            System.out.println("El grupo no existe");
        }
    }

    @Transactional
    @Override
    public void addGroup(Long idCompany, String name, String type) {

        var company = companyService.findById(idCompany).get();
        var image = "https://avatars.dicebear.com/api/identicon/" + name + "adsf" + type + ".png";
        CryGroup group = new CryGroup(name, type, image, company);
        saveGroup(group);
        company.addGroup(group);

    }

    @Transactional
    @Override
    public void deleteGroupById(Long id) {
        cryGroupRepository.delete(cryGroupRepository.findById(id).get());
    }
}
