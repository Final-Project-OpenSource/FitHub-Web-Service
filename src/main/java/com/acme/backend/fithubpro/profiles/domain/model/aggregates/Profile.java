package com.acme.backend.fithubpro.profiles.domain.model.aggregates;

import com.acme.backend.fithubpro.profiles.domain.model.commands.CreateProfileCommand;
import com.acme.backend.fithubpro.profiles.domain.model.valueobjects.EmailAddress;
import com.acme.backend.fithubpro.profiles.domain.model.valueobjects.PersonName;
import com.acme.backend.fithubpro.profiles.domain.model.valueobjects.StreetAddress;
import com.acme.backend.fithubpro.profiles.domain.model.valueobjects.ProfileImageUrl;
import com.acme.backend.fithubpro.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;

@Entity
public class Profile extends AuditableAbstractAggregateRoot<Profile> {


    @Embedded
    private PersonName name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "email_address"))})
    EmailAddress email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "address_street")),
            @AttributeOverride(name = "number", column = @Column(name = "address_number")),
            @AttributeOverride(name = "city", column = @Column(name = "address_city")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "address_postal_code")),
            @AttributeOverride(name = "country", column = @Column(name = "address_country"))})
    private StreetAddress address;

    @Embedded
    private ProfileImageUrl profileImageUrl;


    public Profile(String firstName, String lastName, String email, String street, String number, String city, String postalCode, String country, String profileImageUrl) {
        this.name = new PersonName(firstName, lastName);
        this.email = new EmailAddress(email);
        this.address = new StreetAddress(street, number, city, postalCode, country);
        this.profileImageUrl = new ProfileImageUrl(profileImageUrl);
    }

    public Profile(CreateProfileCommand command) {
        this.name = new PersonName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
        this.address = new StreetAddress(command.street(), command.number(), command.city(), command.postalCode(), command.country());
        this.profileImageUrl = new ProfileImageUrl(command.profileImageUrl());
    }

    public Profile() {
    }

    public void updateName(String firstName, String lastName) {
        this.name = new PersonName(firstName, lastName);
    }

    public void updateEmail(String email) {
        this.email = new EmailAddress(email);
    }

    public void updateAddress(String street, String number, String city, String postalCode, String country) {
        this.address = new StreetAddress(street, number, city, postalCode, country);
    }

    public void updateProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = new ProfileImageUrl(profileImageUrl);
    }

    public String getFullName() {
        return name.getFullName();
    }

    public String getEmailAddress() {
        return email.address();
    }

    public String getStreetAddress() {
        return address.getStreetAddress();
    }

    public String getProfileImageUrl() { return profileImageUrl.url(); }
}
