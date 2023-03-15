package com.shah.starter.model;

public class BrandModel {

    private String brandName;
    private String brandDescription;

    private UserModel user;

    public BrandModel(String username, String password, String brandName, String brandDescription) {
        user = new UserModel(username, password);
        this.brandName = brandName;
        this.brandDescription = brandDescription;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandDescription() {
        return brandDescription;
    }

    public void setBrandDescription(String brandDescription) {
        this.brandDescription = brandDescription;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
