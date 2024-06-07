package com.acme.backend.fithubpro.iam.interfaces.rest;

import com.acme.backend.fithubpro.iam.application.internal.commandservices.UserCommandService;
import com.acme.backend.fithubpro.iam.application.internal.queryservices.UserQueryService;
import com.acme.backend.fithubpro.iam.domain.model.User;
import com.acme.backend.fithubpro.iam.domain.model.commands.SignUpCommand;
import com.acme.backend.fithubpro.iam.domain.model.queries.GetUserQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @summary
 *    The AuthController class is a REST controller that handles authentication operations.
 *    The controller provides endpoints for user registration and login.
 */


@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserCommandService userCommandService;

    @Autowired
    private UserQueryService userQueryService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * @summary
     *    The register method is a POST endpoint that receives a sign-up command and registers a new user.
     *
     * @param command
     *    The sign-up command that contains the username, password, and roles of the user.
     *
     * @return
     *    The registered user object.
     */
    @PostMapping("/register")
    public User register(@RequestBody SignUpCommand command){
        return userCommandService.signUp(command);
    }

    /**
     * @summary
     *    The login method is a POST endpoint that receives a user object and checks if the user exists in the database.
     *    The method returns a message indicating if the login was successful or not.
     *
     * @param user
     *    The user object that contains the username and password of the user.
     *
     * @return
     *    A message indicating if the login was successful or not.
     */

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User foundUser = userQueryService.getUser(new GetUserQuery(user.getUsername()));
        if (foundUser != null && passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
            return "Inicio de sesión exitoso";
        } else {
            return "Inicio de sesión fallido";
        }
    }

}
