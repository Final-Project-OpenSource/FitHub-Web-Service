package com.acme.backend.fithubpro.progress.domain.model.commands;

import java.time.LocalDateTime;

public record CreateProgressCommand(String content, LocalDateTime date, Integer clientId, Integer coachId) {

    public CreateProgressCommand {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content must not be null or empty.");
        }
        if (date == null) {
            throw new IllegalArgumentException("Date must not be null.");
        }
        if (clientId == null) {
            throw new IllegalArgumentException("Client ID must not be null.");
        }
        if (coachId == null) {
            throw new IllegalArgumentException("Coach ID must not be null.");
        }
    }
}
