package com.acme.backend.fithubpro.iam.interfaces.rest.resources;

import java.util.List;

public record SignUpResource(String username, String password, String phoneNumber , List<String> roles) {
}
