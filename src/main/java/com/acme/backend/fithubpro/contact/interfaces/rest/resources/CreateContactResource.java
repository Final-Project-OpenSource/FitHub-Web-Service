package com.acme.backend.fithubpro.contact.interfaces.rest.resources;

public record CreateContactResource(String message, Integer memberId, Integer coachId) {

    public CreateContactResource {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message must not be null or empty.");
        }
        if (memberId == null) {
            throw new IllegalArgumentException("Member ID must not be null.");
        }
        if (coachId == null) {
            throw new IllegalArgumentException("Coach ID must not be null.");
        }
    }
}
