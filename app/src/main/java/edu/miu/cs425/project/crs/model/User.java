package edu.miu.cs425.project.crs.model;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "* Email Address is required.")
    @Email(message = "* Email Address should be valid.")
    @Column(unique = true)
    private String emailAddress;

    @NotNull(message = "* Password is required")
    @Length(min = 5, message = "The field must be at least 5 characters")
    private String password;

    @NotNull(message = "* Full Name is required")
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
