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

    @Column(nullable = false)
    private Long coachId;

    @Column(nullable = true)
    private Long memberId;

    protected NutritionPlan() {
    }

    public NutritionPlan(CreateNutritionPlanCommand command) {
        this.title = command.title();
        this.photo = command.photo();
        this.description = command.description();
        this.ingredients = command.ingredients();
        this.calories = command.calories();
        this.restriction = command.restriction();
        this.goalHealth = command.goalHealth();
        this.coachId = command.coachId();
        this.memberId = command.memberId();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }

    public void setGoalHealth(String goalHealth) {
        this.goalHealth = goalHealth;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
