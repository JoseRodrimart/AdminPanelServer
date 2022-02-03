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
public class Group {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @ManyToOne
    private Company company;
    @ManyToMany
    private List<User> regularUsers = new ArrayList<>();
    @ManyToMany
    private List<User> adminUsers = new ArrayList<>();
}
