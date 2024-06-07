package com.acme.backend.fithubpro.iam.domain.model.queries;

import lombok.Getter;

/**
 * @summary
 *    The GetUserQuery class represents a query to get a user by username.
 *    The query contains the username of the user.
 */

@Getter
public class GetUserQuery {
    private String username;

    public GetUserQuery(String username) {
        this.username = username;
    }

}
