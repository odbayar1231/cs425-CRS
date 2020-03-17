package edu.miu.cs425.project.crs.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "faculties")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "* Faculty name is required")
    @Column(nullable = false, unique = true)
    private String name;
}
