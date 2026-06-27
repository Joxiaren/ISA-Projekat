package com.example.rma_projekat.dtos.login;

import com.google.gson.annotations.SerializedName;

public class LoginRequestDTO {
    @SerializedName("username")
    public String username;
    @SerializedName("password")
    public String password;

    public LoginRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
