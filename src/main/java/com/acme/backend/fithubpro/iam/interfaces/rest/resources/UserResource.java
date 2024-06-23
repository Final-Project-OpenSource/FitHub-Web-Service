package com.acme.backend.fithubpro.iam.interfaces.rest.resources;

import java.util.List;

public record UserResource(Long id, String username, Long phoneNumber, List<String> roles) {
}
