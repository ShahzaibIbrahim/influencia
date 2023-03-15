package com.shah.starter.model;

public class CampaignModel {

    private String name;

    private String description;

    private double unitBudget;

    private int influencerCount;

    public CampaignModel(String name, String description, double unitBudget, int influencerCount) {
        this.name = name;
        this.description = description;
        this.unitBudget = unitBudget;
        this.influencerCount = influencerCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitBudget() {
        return unitBudget;
    }

    public void setUnitBudget(double unitBudget) {
        this.unitBudget = unitBudget;
    }

    public int getInfluencerCount() {
        return influencerCount;
    }

    public void setInfluencerCount(int influencerCount) {
        this.influencerCount = influencerCount;
    }
}
