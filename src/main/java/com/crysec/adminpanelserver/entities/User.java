package com.crysec.adminpanelserver.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class User {
    @Id
    private Long id;
    @Column
    private String name;
    @Email
    private String mail;
    @ManyToOne
    private Company company;
}
