package edu.miu.cs425.project.crs.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @Pattern(regexp = "^[A-Z,a-z]{2,3}\\d{3}$", message = "* Course Id pattern should in this format: XX123 or XXX123")
    private String id;
    @NotBlank(message = "* Course name is required")
    @Column(unique = true, nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @ManyToMany()
    @JoinTable(
            name = "course_prerequisite",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns =  @JoinColumn(name = "prerequisite_id")
    )
    private List<Course> prerequisites = new ArrayList<>();

    @ManyToMany(mappedBy = "prerequisites")
    private List<Course> courses = new ArrayList<>();


    @OneToMany(mappedBy = "course")
    private List<Class> classes = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Course)) {
            return false;
        }
        Course c = (Course) o;
        return this.id.equals(c.id) && this.name.equals(c.name);
    }
}
