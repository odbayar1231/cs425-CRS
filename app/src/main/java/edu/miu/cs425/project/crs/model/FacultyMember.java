package edu.miu.cs425.project.crs.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "faculty_members")
public class FacultyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @Column(nullable = false)
    private String fullName;
    private String contactNumber;
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
}
