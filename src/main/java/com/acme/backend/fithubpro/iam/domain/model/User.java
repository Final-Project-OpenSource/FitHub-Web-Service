package com.acme.backend.fithubpro.iam.domain.model;

import  javax.persistence.*;
import java.util.Set;

/**
 * <summary>
 *     The User entity represents a user in the system.
 *     The user has a unique username, a password, and a set of roles.
 *     The roles are stored as a set of strings.
 *     The roles field is an element collection of strings.
 * </summary>
 */

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;

    // Getters and setters

    // Id is the primary key of the User entity
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    // Username is unique and cannot be null
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    // Password cannot be null
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // Roles are stored as a set of strings
    public Set<String> getRoles() {
        return roles;
    }
    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

}
