package edu.miu.cs425.project.crs.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "* role name is required and cannot be empty.")
    @Column(nullable = false)
    private String name;
}
