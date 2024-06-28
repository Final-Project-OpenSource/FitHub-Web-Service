package com.acme.backend.fithubpro.profiles.domain.model.queries;

import com.acme.backend.fithubpro.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
