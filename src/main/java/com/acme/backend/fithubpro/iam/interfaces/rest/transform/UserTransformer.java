package com.acme.backend.fithubpro.iam.interfaces.rest.transform;

import com.acme.backend.fithubpro.iam.interfaces.rest.resources.UserDTO;
import com.acme.backend.fithubpro.iam.domain.model.User;

public class UserTransformer {

    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRoles(user.getRoles());
        return dto;
    }

    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setRoles(dto.getRoles());
        return user;
    }
}
