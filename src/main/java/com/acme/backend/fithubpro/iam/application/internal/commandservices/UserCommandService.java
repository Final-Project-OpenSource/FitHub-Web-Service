package com.acme.backend.fithubpro.iam.application.internal.commandservices;

import com.acme.backend.fithubpro.iam.domain.model.commands.SignUpCommand;
import com.acme.backend.fithubpro.iam.domain.model.aggregates.UserAggregate;
import com.acme.backend.fithubpro.iam.domain.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCommandService {

    @Autowired
    private UserAggregate userAggregate;

    public User signUp(SignUpCommand command){
        return userAggregate.signUp(command);
    }
}
