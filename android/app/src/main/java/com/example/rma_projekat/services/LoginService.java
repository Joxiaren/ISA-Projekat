package com.example.rma_projekat.services;

import com.example.rma_projekat.dtos.login.LoginRequestDTO;
import com.example.rma_projekat.dtos.login.LoginResponseDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {
    @POST("/auth/login")
    Call<LoginResponseDTO> login(@Body LoginRequestDTO request);
}
