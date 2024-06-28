package com.acme.backend.fithubpro.rutines.interfaces.rest.resources;

public record CreateRutinesResource(String name, String exercise, String repetition, String photo, String instruction, Long coachId, Long memberId) {
}
