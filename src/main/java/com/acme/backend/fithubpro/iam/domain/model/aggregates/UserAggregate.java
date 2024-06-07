package com.acme.backend.fithubpro.iam.domain.model.aggregates;

import com.acme.backend.fithubpro.iam.domain.model.User;
import com.acme.backend.fithubpro.iam.domain.repository.IUserRepository;
import com.acme.backend.fithubpro.iam.domain.model.commands.SignUpCommand;
import com.acme.backend.fithubpro.iam.domain.model.queries.GetUserQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAggregate {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User signUp(SignUpCommand command){

        User user = new User();
        user.setUsername(command.getUsername());
        user.setPassword(passwordEncoder.encode(command.getPassword()));
        user.setRoles(command.getRoles());

        return userRepository.save(user);
    }

    public User findUserByQuery(GetUserQuery query){
        return userRepository.findByUsername(query.getUsername()).orElse(null);
    }

    public List<User> listUsers(){
        return userRepository.findAll();
    }

}
