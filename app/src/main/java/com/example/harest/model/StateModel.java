package com.example.harest.model;

public class StateModel {

    private String entity_id;
    private String last_changed;
    private String state;

    public StateModel() {
    }

    public StateModel(String entity_id, String last_changed, String state) {
        this.entity_id = entity_id;
        this.last_changed = last_changed;
        this.state = state;
    }

    public String getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(String entity_id) {
        this.entity_id = entity_id;
    }

    public String getLast_changed() {
        return last_changed;
    }

    public void setLast_changed(String last_changed) {
        this.last_changed = last_changed;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
