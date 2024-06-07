package com.acme.backend.fithubpro.iam.domain.model.commands;

import java.util.Set;

/**
 * @param username Getters
 * @summary The SignUpCommand class represents a command to sign up a user.
 * The command contains the username, password, and roles of the user.
 */


public record SignUpCommand(String username, String password, Set<String> roles) {
}