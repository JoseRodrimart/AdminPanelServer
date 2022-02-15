package com.crysec.adminpanelserver.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class CryUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column
    private String name;
    @Email
    private String mail;
    @Column
    private String image;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "company_id")
    private Company company;


    public CryUser(String mail) {
        this.mail = mail;
    }

}
