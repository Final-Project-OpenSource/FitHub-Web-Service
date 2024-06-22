package com.acme.backend.fithubpro.subscription.interfaces.rest.transform;

import com.acme.backend.fithubpro.subscription.domain.model.aggregates.Membership;
import com.acme.backend.fithubpro.subscription.interfaces.rest.resources.MembershipResource;

public class MembershipResourceFromEntityAssembler {
    public static MembershipResource toResourceFromEntity(Membership entity) {
        return new MembershipResource(entity.getId(), entity.getBenefits(), entity.getPrice(), entity.getType());
    }
}
