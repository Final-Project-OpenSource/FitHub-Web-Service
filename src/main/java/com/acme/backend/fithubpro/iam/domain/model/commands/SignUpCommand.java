package com.acme.backend.fithubpro.iam.domain.model.commands;

import java.util.Set;

/**
 * @summary
 *    The SignUpCommand class represents a command to sign up a user.
 *    The command contains the username, password, and roles of the user.
 */

public class SignUpCommand {
    private String username;
    private String password;
    private Set<String> roles;

    // Constructor
    public SignUpCommand(String username, String password, Set<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    // Getters
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public Set<String> getRoles() {
        return roles;
    }
}