package com.acme.backend.fithubpro.subscription.domain.model.aggregates;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.BaseEntity;
import com.acme.backend.fithubpro.subscription.domain.model.commands.CreateMembershipCommand;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class Membership extends BaseEntity<Membership> {
    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String benefits;

    protected Membership(){}

    public Membership(CreateMembershipCommand command) {
        this.price = command.price();
        this.type = command.type();
        this.benefits = command.benefits();
    }

    public Membership updateInformation(Double price, String type, String benefits) {
        this.price = price;
        this.type = type;
        this.benefits = benefits;
        return this;
    }

}

