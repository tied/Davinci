package com.jpmc.gti.adp.models;

import java.util.List;


public class Workflow extends BaseModel {


    private List<Action> actions;
    private List<Status> statuses;


    public List<Action> getActions() { return actions; }

    public void setActions(List<Action> actions) { this.actions = actions; }

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }
}