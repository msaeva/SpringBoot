package com.example.mobileproject.domain.dtos;

import com.example.mobileproject.domain.enums.Role;
import jakarta.persistence.UniqueConstraint;

import javax.validation.constraints.NotNull;
import java.util.List;

public class UserRegisterDto {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private List<String> roles;

    public UserRegisterDto() {
    }

    public UserRegisterDto(String firstName, String lastName, String username, String password, List<String> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<String> getRoles() {
        return roles;
    }

    public UserRegisterDto setRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }
}
