/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbla.fblaproject.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Tharun Saravanan
 */
@Entity
public class Quarter {
    @Id
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getSchoolReward() {
        return schoolReward;
    }

    public void setSchoolReward(String schoolReward) {
        this.schoolReward = schoolReward;
    }

    public String getFoodReward() {
        return foodReward;
    }

    public void setFoodReward(String foodReward) {
        this.foodReward = foodReward;
    }

    public String getSchoolSprit() {
        return schoolSprit;
    }

    public void setSchoolSprit(String schoolSprit) {
        this.schoolSprit = schoolSprit;
    }

    public Boolean getDrawCompleted() {
        return drawCompleted;
    }

    public void setDrawCompleted(Boolean drawCompleted) {
        this.drawCompleted = drawCompleted;
    }

    public Quarter() {
    }
    private LocalDate startDate;
    private LocalDate endDate;
    private String schoolReward;
    private String foodReward;
    private String schoolSprit;
    private Boolean drawCompleted;
    
}
