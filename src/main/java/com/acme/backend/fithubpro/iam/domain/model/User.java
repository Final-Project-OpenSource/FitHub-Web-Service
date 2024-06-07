package com.acme.backend.fithubpro.iam.domain.model;

import lombok.Getter;
import lombok.Setter;

import  javax.persistence.*;
import java.util.Set;

/**
 * @summary
 *    The User entity represents a user in the system.
 *    The user has a unique username, a password, and a set of roles.
 *    The roles are stored as a set of strings.
 */

@Setter
@Getter
@Entity
public class User {

    /**
     * @summary
     *    The id of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * @summary
     *    The username of the user.
     *    The username is stored as a string.
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * @summary
     *    The password of the user.
     *    The password is stored as a string.
     */
    @Column(nullable = false)
    private String password;

    /**
     * @summary
     *    The roles of the user.
     *    The roles are stored as a set of strings.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;


}
