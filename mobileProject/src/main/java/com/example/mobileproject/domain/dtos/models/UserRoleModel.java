package com.example.mobileproject.domain.dtos.models;

public class UserRoleModel {
    private Long id;
    private String role;

    public Long getId() {
        return id;
    }

    public UserRoleModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UserRoleModel setRole(String role) {
        this.role = role;
        return this;
    }
}
