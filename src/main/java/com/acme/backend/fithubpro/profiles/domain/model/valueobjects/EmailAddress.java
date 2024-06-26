package com.acme.backend.fithubpro.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;

/**
 * <p>Value object representing an email address.</p>
 */
@Embeddable
public record EmailAddress(@Email String address) {
    public EmailAddress() { this(null); }
}
