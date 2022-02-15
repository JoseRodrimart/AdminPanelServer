package com.crysec.adminpanelserver.entities;

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
    private String description;
    @Column
    private String image;

    @ManyToMany(cascade = {CascadeType.ALL})
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

    public void addRegularUser(CryUser user){
        adminUsers.remove(user);
        regularUsers.add(user);
    }

    public void addAdminUser(CryUser user){
        regularUsers.remove(user); //If already present in regularUser, move to Admin
        adminUsers.add(user);
    }
}
