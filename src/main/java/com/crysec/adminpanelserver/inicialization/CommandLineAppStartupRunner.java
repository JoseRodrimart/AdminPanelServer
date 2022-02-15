package com.crysec.adminpanelserver.inicialization;

import com.crysec.adminpanelserver.entities.Company;
import com.crysec.adminpanelserver.entities.CryGroup;
import com.crysec.adminpanelserver.entities.CryUser;
import com.crysec.adminpanelserver.services.CompanyService;
import com.crysec.adminpanelserver.services.CryGroupService;
import com.crysec.adminpanelserver.services.CryUserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.logging.Logger;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    CompanyService companyService;
    @Autowired
    CryUserService cryUserService;
    @Autowired
    CryGroupService cryGroupService;

    @Override
    @Transactional
    public void run(String...args) throws Exception {

        CryUser userA  = new CryUser("jose@mail.com");
        CryUser userB = new CryUser("fernando@mail.com");
        cryUserService.saveUser(userA);
        cryUserService.saveUser(userB);

        Company company = new Company("Crysec");
        companyService.saveCompany(company);

        CryGroup group = new CryGroup("Grupo prueba");
        cryGroupService.saveGroup(group);

        group.addAdminUser(userA);
        group.addRegularUser(userB);

        userA.setCompany(company);
        userB.setCompany(company);
//        userA.setCompany(company);
//        userB.setCompany(company);

//        cryUserService.saveUser(userA);
//        cryUserService.saveUser(userB);

        company.addGroup(group);

//        companyService.saveCompany(company);

        System.out.println("StartupRunner completed");
    }
}