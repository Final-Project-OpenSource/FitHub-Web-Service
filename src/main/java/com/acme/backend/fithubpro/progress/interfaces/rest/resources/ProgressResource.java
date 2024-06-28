package com.acme.backend.fithubpro.progress.interfaces.rest.resources;

import java.time.LocalDateTime;

public record ProgressResource(Long id, String content, LocalDateTime date, Integer clientId, Integer coachId) {}
