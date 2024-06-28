package com.acme.backend.fithubpro.profiles.interfaces.rest.transform;
import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Member;
import com.acme.backend.fithubpro.profiles.interfaces.rest.resources.MemberResource;

public class MemberResourceFromEntityAssembler {
    public static MemberResource toResourceFromEntity(Member member) {
        return new MemberResource(member.getId(), member.getProfileId(), member.getHealthGoal());
    }
}
