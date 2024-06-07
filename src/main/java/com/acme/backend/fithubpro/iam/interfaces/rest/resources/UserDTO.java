package com.acme.backend.fithubpro.iam.interfaces.rest.resources;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class UserDTO {
    private Long id;
    private String username;
    private Set<String> roles;

}
