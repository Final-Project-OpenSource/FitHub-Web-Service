package com.acme.backend.fithubpro.profiles.interfaces.rest.resources;

/**
 * Resource class for a profile.
 */
public record ProfileResource(Long id,
                              String fullName,
                              String email,
                              String streetAddress,
                              String profileImageUrl) {
}
