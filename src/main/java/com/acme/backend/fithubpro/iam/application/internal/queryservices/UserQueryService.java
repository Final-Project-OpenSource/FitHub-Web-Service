package com.acme.backend.fithubpro.iam.application.internal.queryservices;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.acme.backend.fithubpro.iam.domain.model.User;
import com.acme.backend.fithubpro.iam.domain.model.aggregates.UserAggregate;
import com.acme.backend.fithubpro.iam.domain.model.queries.GetUserQuery;

import java.util.List;

@Service
public class UserQueryService {

    @Autowired
    private UserAggregate userAggregate;

    public User getUser(GetUserQuery query){
        return userAggregate.findUserByQuery(query);
    }

    public List<User> listUsers(){
        return userAggregate.listUsers();
    }
}
