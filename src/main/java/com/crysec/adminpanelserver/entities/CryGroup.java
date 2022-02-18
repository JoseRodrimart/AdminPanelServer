package com.crysec.adminpanelserver.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class CryGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column
    private String name;

    @Column
    private EGroupType type;

    @Column
    private String image;

 /*   @ToString.Exclude*/
    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "CryGroup_regularUsers",
            joinColumns = @JoinColumn(name = "CryGroup_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "regularUsers_id", referencedColumnName = "id"))
    private List<CryUser> regularUsers = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "CryGroup_adminUsers",
            joinColumns = @JoinColumn(name = "CryGroup_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "adminUsers_id", referencedColumnName = "id"))
    private List<CryUser> adminUsers = new ArrayList<>();

    public CryGroup(String name) {
        this.name = name;
    }

    public CryGroup(String name, EGroupType type, String image, Company company, List<CryUser> regularUsers, List<CryUser> adminUsers) {
        this.name = name;
        this.type = type;
        this.image = image;
        this.company = company;
        this.regularUsers = regularUsers;
        this.adminUsers = adminUsers;
    }

    public CryGroup(String name, String type, String image) {
        this.name = name;
        this.type = EGroupType.valueOf(type);
        this.image = image;
    }

    public CryGroup(String name, String type, String image, Company company) {
        this.name = name;
        this.type = EGroupType.valueOf(type);
        this.image = image;
    }

    public void addRegularUser(CryUser user){
        adminUsers.remove(user);
        regularUsers.add(user);
    }

    public void addAdminUser(CryUser user){
        regularUsers.remove(user); //If already present in regularUser, move to Admin
        adminUsers.add(user);
    }
}
