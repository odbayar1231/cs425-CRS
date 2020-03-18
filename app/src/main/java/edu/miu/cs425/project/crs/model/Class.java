package edu.miu.cs425.project.crs.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "classes")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;

    @ManyToOne
    @JoinColumn(name = "faculty_member_id")
    private FacultyMember facultyMember;

    @NotBlank
    private String roomNumber;
    @NotBlank
    private String building;

    @NotBlank
    private int availableSeats;

    @ManyToMany(mappedBy = "classes")
    private Set<User> students = new HashSet<>();

}
