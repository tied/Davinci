package com.jpmc.gti.adp.models;

import java.util.List;


public class Action extends BaseModel {

    private List<Step> steps;


    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}