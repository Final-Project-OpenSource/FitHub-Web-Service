package com.acme.backend.fithubpro.iam.domain.model.queries;


/**
 * @summary The GetUserQuery class represents a query to get a user by username.
 * The query contains the username of the user.
 */


public record GetUserQuery(String username) {

}
