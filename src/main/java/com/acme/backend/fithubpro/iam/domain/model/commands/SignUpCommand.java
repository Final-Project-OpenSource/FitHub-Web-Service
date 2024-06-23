package com.acme.backend.fithubpro.iam.domain.model.commands;

import com.acme.backend.fithubpro.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, Long phoneNumber ,List<Role> roles) {
}
