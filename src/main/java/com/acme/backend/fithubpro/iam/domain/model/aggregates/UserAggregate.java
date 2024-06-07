package com.acme.backend.fithubpro.iam.domain.model.aggregates;

import com.acme.backend.fithubpro.iam.domain.model.User;
import com.acme.backend.fithubpro.iam.domain.repository.IUserRepository;
import com.acme.backend.fithubpro.iam.domain.model.commands.SignUpCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserAggregate {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User signUp(String username, String password, Set<String> roles){

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(roles);

        return userRepository.save(user);
    }

    public User signIn(String username, String password){

        User user = userRepository.findByUsername(username);

        if(user != null && passwordEncoder.matches(password, user.getPassword())){
            return user;
        }

        return null;
    }

}
