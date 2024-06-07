package com.acme.backend.fithubpro.iam.domain.model.aggregates;

import com.acme.backend.fithubpro.iam.domain.model.User;
import com.acme.backend.fithubpro.iam.domain.repository.IUserRepository;
import com.acme.backend.fithubpro.iam.domain.model.commands.SignUpCommand;
import com.acme.backend.fithubpro.iam.domain.model.queries.GetUserQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @summary
 *    The UserAggregate class represents the user aggregate.
 *    The aggregate is responsible for handling user-related operations.
 */

@Service
public class UserAggregate {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * @summary
     *    The signUp method registers a new user in the database.
     *
     * @param command
     *    The sign-up command that contains the username, password, and roles of the user.
     *
     * @return
     *    The registered user object.
     */
    public User signUp(SignUpCommand command){

        User user = new User();
        user.setUsername(command.username());
        user.setPassword(passwordEncoder.encode(command.password()));
        user.setRoles(command.roles());

        return userRepository.save(user);
    }

    /**
     * @summary
     *    The findUserByQuery method retrieves a user from the database using a query.
     *
     * @param query
     *    The query that contains the username of the user.
     *
     * @return
     *    The user object.
     */
    public User findUserByQuery(GetUserQuery query){
        return userRepository.findByUsername(query.username()).orElse(null);
    }

    /**
     * @summary
     *    The listUsers method retrieves all users from the database.
     *
     * @return
     *    A list of user objects.
     */
    public List<User> listUsers(){
        return userRepository.findAll();
    }

}
