package com.crysec.adminpanelserver.inicialization;

import com.crysec.adminpanelserver.entities.Company;
import com.crysec.adminpanelserver.entities.CryGroup;
import com.crysec.adminpanelserver.entities.CryUser;
import com.crysec.adminpanelserver.entities.EGroupType;
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
        userA.setName("Jose");
        CryUser userB = new CryUser("fernando@mail.com");
        userA.setName("Fernando");
        CryUser userC  = new CryUser("juan@mail.com");
        userA.setName("Juan");
        CryUser userD  = new CryUser("blas@mail.com");
        userA.setName("Blas");
        CryUser userE  = new CryUser("ruben@mail.com");
        userA.setName("Rubén");
        CryUser userF  = new CryUser("emilio@mail.com");
        userA.setName("Emilio");
        CryUser userG  = new CryUser("carlos@mail.com");
        userA.setName("Carlos");
        CryUser userH  = new CryUser("sandra@mail.com");
        userA.setName("Sandra");
        CryUser userI  = new CryUser("manu@mail.com");
        userA.setName("Manuel");
        CryUser userJ  = new CryUser("joaquin@mail.com");
        userA.setName("Joaquín");


        CryUser userK  = new CryUser("miguel@mail.com");
        userA.setName("Miguel");
        CryUser userL = new CryUser("ricardo@mail.com");
        userA.setName("Ricardo");

        cryUserService.saveUser(userA);
        cryUserService.saveUser(userB);
        cryUserService.saveUser(userC);
        cryUserService.saveUser(userD);
        cryUserService.saveUser(userE);
        cryUserService.saveUser(userF);
        cryUserService.saveUser(userG);
        cryUserService.saveUser(userH);
        cryUserService.saveUser(userI);
        cryUserService.saveUser(userJ);
        cryUserService.saveUser(userK);
        cryUserService.saveUser(userL);



        Company company = new Company("1","Crysec", "https://avatars.dicebear.com/api/identicon/crysecloco.png");
        companyService.saveCompany(company);
        Company company2 = new Company("2","Paco Mollá", "https://avatars.dicebear.com/api/identicon/company2pacomollas.png");
        companyService.saveCompany(company2);

        CryGroup group = new CryGroup("Diseño");
        CryGroup group2 = new CryGroup("Desarrollo");

        CryGroup group3 = new CryGroup("Profesores");
        CryGroup group4 = new CryGroup("Alumnos");

        group.setCompany(company);
        group2.setCompany(company);

        group3.setCompany(company2);
        group4.setCompany(company2);

        cryGroupService.saveGroup(group);
        cryGroupService.saveGroup(group2);
        cryGroupService.saveGroup(group3);
        cryGroupService.saveGroup(group4);

        group.setImage("https://avatars.dicebear.com/api/identicon/asdklfjlasdkjfasghfuyqgwufygsdauhgchjasa.png");
        group.setType(EGroupType.Notifications);

        group2.setImage("https://avatars.dicebear.com/api/identicon/agroup2alksdjfñlasfsa.png");
        group2.setType(EGroupType.Test);

        group3.setImage("https://avatars.dicebear.com/api/identicon/asdklfjlasdkjgorup3fasghfuyqgwufygsdauhgchjasa.png");
        group3.setType(EGroupType.Chat);

        group4.setImage("https://avatars.dicebear.com/api/identicon/asdklfjlasdgroup444hgchjasa.png");
        group4.setType(EGroupType.Notifications);


        userA.setCompany(company);
        userA.setImage("https://avatars.dicebear.com/api/identicon/your-custom-aJHKDSAFGUYAGSYGSJHDS.png");
        userB.setCompany(company);
        userB.setImage("https://avatars.dicebear.com/api/identicon/your-custoASKDJLHFAKJHSDGFUYAm-b.png");
        userC.setCompany(company2);
        userC.setImage("https://avatars.dicebear.com/api/identicon/yASDHFGAJYJSHDGFVCJHAGHJSDGCHJKour-custom-c.png");
        userD.setCompany(company);
        userD.setImage("https://avatars.dicebear.com/api/identicon/youASDFJHCAIUYREWCHBADSKJHCBNKAJSNCr-custom-d.png");
        userE.setCompany(company);
        userE.setImage("https://avatars.dicebear.com/api/identicon/your-cusUSUARAIO5tom-aJHKDSAFGUYAGSYGSJHDS.png");
        userF.setCompany(company2);
        userE.setImage("https://avatars.dicebear.com/api/identicon/your-custom-aJHKDASDJKLFJ6SAFGUYAGSYGSJHDS.png");
        userG.setCompany(company2);
        userG.setImage("https://avatars.dicebear.com/api/identicon/your-custom-aJHKDSAFGUYAusuario7SYGSJHDS.png");
        userH.setCompany(company2);
        userH.setImage("https://avatars.dicebear.com/api/identicon/your-custom-aJHKDSAFGUYAGSYGSJHusuario8S.png");
        userI.setCompany(company);
        userI.setImage("https://avatars.dicebear.com/api/identicon/your-custom-aJHKDSAFGUYAusuario9HDS.png");
        userJ.setCompany(company2);
        userJ.setImage("https://avatars.dicebear.com/api/identicon/your-custom-aJHKDSAFGUusaurio10JHDS.png");
        userK.setCompany(company2);
        userK.setImage("https://avatars.dicebear.com/api/identicon/your-custom-aJHKDSAFGUYAGSYGSJasdjfkasklff11DS.png");
        userL.setCompany(company2);
        userL.setImage("https://avatars.dicebear.com/api/identicon/your-custom-aJHKDSAFGUYAGSYalksjdf12GSJHDS.png");

        group.addRegularUser(userA);
        group.addRegularUser(userB);

        group2.addRegularUser(userE);
        group2.addRegularUser(userD);
        group2.addRegularUser(userI);

        group3.addRegularUser(userK);
        group3.addRegularUser(userL);
        group3.addRegularUser(userH);

        group4.addRegularUser(userC);
        group4.addRegularUser(userF);
        group4.addRegularUser(userG);


        company.addGroup(group);
        company.addGroup(group2);
        company2.addGroup(group3);
        company2.addGroup(group4);

        System.out.println("StartupRunner completed");
    }
}