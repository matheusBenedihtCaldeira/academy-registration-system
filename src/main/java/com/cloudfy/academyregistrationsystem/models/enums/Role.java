package com.cloudfy.academyregistrationsystem.models.enums;

public enum Role {
    ADMIN("admin"),
    CUSTOMER("customer"),
    OPERATOR("operator");

    private String role;

    Role(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}