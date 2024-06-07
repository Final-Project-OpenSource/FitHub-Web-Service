package com.acme.backend.fithubpro.iam.interfaces.rest;

import com.acme.backend.fithubpro.iam.application.internal.commandservices.UserCommandService;
import com.acme.backend.fithubpro.iam.application.internal.queryservices.UserQueryService;
import com.acme.backend.fithubpro.iam.domain.model.commands.SignUpCommand;
import com.acme.backend.fithubpro.iam.domain.model.queries.GetUserQuery;
import com.acme.backend.fithubpro.iam.interfaces.rest.resources.UserDTO;
import com.acme.backend.fithubpro.iam.interfaces.rest.transform.UserTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserCommandService userCommandService;

    @Autowired
    private UserQueryService userQueryService;

    @GetMapping("/{username}")
    public UserDTO getUser(@PathVariable String username){
        return UserTransformer.toDTO(userQueryService.getUser(new GetUserQuery(username)));
    }

    @PostMapping
    public UserDTO signUp(@RequestBody SignUpCommand command){
        return UserTransformer.toDTO(userCommandService.signUp(command));
    }

    @GetMapping
    public List<UserDTO> listUsers(){
        return userQueryService.listUsers().stream()
                .map(UserTransformer::toDTO)
                .collect(Collectors.toList());
    }
}
