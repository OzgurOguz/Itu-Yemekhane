package com.example.ozgur.itu_yemekhane.getterSetters;

import java.util.List;


public class MealsUpdate {

    private List mealsLists;
    private List detailsLists;

    public MealsUpdate() {
    }

    public List getMealsLists() {
        return mealsLists;
    }

    public void setMealsLists(List mealsLists) {
        this.mealsLists = mealsLists;
    }

    public List getDetailsLists() {
        return detailsLists;
    }

    public void setDetailsLists(List detailsLists) {
        this.detailsLists = detailsLists;
    }
}
