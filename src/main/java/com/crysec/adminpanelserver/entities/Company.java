package com.crysec.adminpanelserver.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {
    @Id
    private Long id;
    @Column
    private String name;
    @OneToMany
    private List<User> users = new ArrayList<>();
}
