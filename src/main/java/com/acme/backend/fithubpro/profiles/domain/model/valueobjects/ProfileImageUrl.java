package com.acme.backend.fithubpro.profiles.domain.model.valueobjects;

import javax.persistence.Embeddable;

@Embeddable
public record ProfileImageUrl(String url) {
    public ProfileImageUrl() { this(null); }
}
