package com.acme.backend.fithubpro.iam.domain.services;

import com.acme.backend.fithubpro.iam.domain.model.aggregates.User;
import com.acme.backend.fithubpro.iam.domain.model.queries.GetAllUsersQuery;
import com.acme.backend.fithubpro.iam.domain.model.queries.GetUserByIdQuery;
import com.acme.backend.fithubpro.iam.domain.model.queries.GetUserByUsernameQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByUsernameQuery query);

}
