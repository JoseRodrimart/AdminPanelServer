package com.crysec.adminpanelserver.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.ToString.Exclude;
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
    @JsonIgnore
    @Column(unique = true)
    private String cod;
    @Column(unique = true)
    private String name;
    @Column
    private String image;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<CryUser> cryUsers = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<CryGroup> cryGroups = new ArrayList<>();

    public Company(String cod, String name) {
        this.cod = cod;
        this.name = name;
    }

    public Company(String cod, String name, String image) {
        this.cod = cod;
        this.name = name;
        this.image = image;
    }

    public void addUser(CryUser user){ cryUsers.add(user);}
    public void addGroup(CryGroup group){ cryGroups.add(group);}
}
