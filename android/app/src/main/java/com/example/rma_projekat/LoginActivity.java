package com.example.rma_projekat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.rma_projekat.dtos.login.LoginRequestDTO;
import com.example.rma_projekat.dtos.login.LoginResponseDTO;
import com.example.rma_projekat.services.LoginService;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button loginButton = (Button)findViewById(R.id.loginButton);

        EditText urlEditText = (EditText)findViewById(R.id.urlEditText);
        EditText usernameEditText = (EditText)findViewById(R.id.usernameEditText);
        EditText passwordEditText = (EditText)findViewById(R.id.passwordEditText);

        loginButton.setOnClickListener( v -> {
            String url = urlEditText.getText().toString();
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            Retrofit retrofitInstance = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                    .build();

            var retrofitService = retrofitInstance.create(LoginService.class);

            LoginRequestDTO request = new LoginRequestDTO(usernameEditText.getText().toString(), passwordEditText.getText().toString());

            Call<LoginResponseDTO> call = retrofitService.login(request);
            call.enqueue(new Callback<LoginResponseDTO>() {
                @Override
                public void onResponse(Call<LoginResponseDTO> call, Response<LoginResponseDTO> response) {
                    if(response.isSuccessful() && response.body() != null){
                        Toast.makeText(v.getContext(), "Login success!", Toast.LENGTH_SHORT).show();

                        Bundle b = new Bundle();
                        b.putString("username", username);
                        b.putString("url", url);
                        b.putString("auth_token", response.body().token);

                        Intent i = new Intent(v.getContext(), MainActivity.class);
                        i.putExtras(b);

                        startActivity(i);
                    }
                    else{
                        Toast.makeText(v.getContext(), "Login failed with code: " + response.code(), Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<LoginResponseDTO> call, Throwable throwable) {
                    Log.i("Network error", throwable.getMessage());
                }
            });
        });
    }
}