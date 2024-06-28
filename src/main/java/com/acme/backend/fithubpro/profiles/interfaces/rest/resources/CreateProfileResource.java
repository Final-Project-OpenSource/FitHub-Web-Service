package com.acme.backend.fithubpro.profiles.interfaces.rest.resources;
/**
 * Resource class for creating a profile.
 */
public record CreateProfileResource(String firstName,
                                    String lastName,
                                    String email,
                                    String street,
                                    String number,
                                    String city,
                                    String postalCode,
                                    String country,
                                    String profileImageUrl) {
}
