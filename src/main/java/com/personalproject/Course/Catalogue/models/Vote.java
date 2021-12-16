package com.personalproject.Course.Catalogue.models;

public class Vote {
    String username;
    int entityId;
    String action;
    String entityType;          //post or comment

    public Vote(String username, int entityId, String action,String entityType) {
        this.username = username;
        this.entityId = entityId;
        this.action = action;
        this.entityType = entityType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "username='" + username + '\'' +
                ", entityId=" + entityId +
                ", action='" + action + '\'' +
                ",entityType='"+entityType+'\''+
                '}';
    }
}
