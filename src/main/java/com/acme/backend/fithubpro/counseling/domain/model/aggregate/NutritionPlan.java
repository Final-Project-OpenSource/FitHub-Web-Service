package com.acme.backend.fithubpro.counseling.domain.model.aggregate;

import com.acme.backend.fithubpro.counseling.domain.model.commands.CreateNutritionPlanCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class NutritionPlan extends BaseEntity<NutritionPlan> {

    @Column(nullable = false)
    private String title;
    /**
     * The ID of the favorite source.
     */
    @Column(nullable = false)
    private String photo;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String ingredients;

    @Column(nullable = false)
    private String calories;

    @Column(nullable = false)
    private String restriction;

    @Column(nullable = false)
    private String goalHealth;


    protected NutritionPlan() {
    }

    /**
     * Creates a new FavoriteSource instance.
     * @param command The command to create a favorite source.
     */

    public NutritionPlan(CreateNutritionPlanCommand command) {
        this.title = command.title();
        this.photo = command.photo();
        this.description = command.description();
        this.ingredients = command.ingredients();
        this.calories = command.calories();
        this.restriction = command.restriction();
        this.goalHealth = command.goalHealth();
    }
}
