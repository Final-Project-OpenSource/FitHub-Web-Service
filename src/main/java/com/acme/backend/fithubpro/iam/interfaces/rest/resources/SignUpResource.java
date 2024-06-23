package com.acme.backend.fithubpro.iam.interfaces.rest.resources;

import java.util.List;

public record SignUpResource(String username, String password, Long phoneNumber , List<String> roles) {
}
