package com.acme.backend.fithubpro.contact.domain.model.commands;

public record CreateContactCommand(String message, Integer memberId, Integer coachId) {

    public CreateContactCommand {
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
