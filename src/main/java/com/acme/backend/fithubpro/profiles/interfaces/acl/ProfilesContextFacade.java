package com.acme.backend.fithubpro.profiles.interfaces.acl;

import com.acme.backend.fithubpro.profiles.domain.model.commands.CreateProfileCommand;
import com.acme.backend.fithubpro.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.acme.backend.fithubpro.profiles.domain.model.valueobjects.EmailAddress;
import com.acme.backend.fithubpro.profiles.domain.services.ProfileCommandService;
import com.acme.backend.fithubpro.profiles.domain.services.ProfileQueryService;
import org.springframework.stereotype.Service;

/**
 * Service Facade for the Profile context.
 *
 * <p>
 *     It is used to create a new Profile and fetch the Profile id by email.
 *     It uses the {@link ProfileCommandService} and {@link ProfileQueryService} to interact with the Profile context.
 *     It is used by the other contexts to interact with the Profile context.
 * </p>
 *
 * @see ProfileCommandService
 * @see ProfileQueryService
 * @see CreateProfileCommand
 * @see GetProfileByEmailQuery
 *
 */
@Service
public class ProfilesContextFacade {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfilesContextFacade(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }

    /**
     * Creates a new Profile
     *
     * @param firstName the first name
     * @param lastName the last name
     * @param email the email of contact
     * @param street the name street
     * @param number the number of the street
     * @param city the name of the city
     * @param postalCode the postal code
     * @param country the country
     * @param profileImageUrl the profile image url
     */
    public Long createProfile(String firstName, String lastName, String email, String street, String number, String city, String postalCode, String country, String profileImageUrl) {
        var createProfileCommand = new CreateProfileCommand(firstName, lastName, email, street, number, city, postalCode, country, profileImageUrl);
        var profile = profileCommandService.handle(createProfileCommand);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();
    }

    /**
     * Fetches the profile id by email
     *
     * @param email the email
     * @return the profile id
     */
    public Long fetchProfileIdByEmail(String email) {
        var getProfileByEmailQuery = new GetProfileByEmailQuery(new EmailAddress(email));
        var profile = profileQueryService.handle(getProfileByEmailQuery);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();

    }
}