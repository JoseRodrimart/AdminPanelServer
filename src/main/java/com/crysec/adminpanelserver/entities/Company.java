package com.crysec.adminpanelserver.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<CryUser> cryUsers = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL})
    private List<CryGroup> cryGroups = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public void addUser(CryUser user){ cryUsers.add(user);}
    public void addGroup(CryGroup group){ cryGroups.add(group);}
}
