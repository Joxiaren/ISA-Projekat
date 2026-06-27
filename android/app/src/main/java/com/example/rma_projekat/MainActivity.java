package com.example.rma_projekat;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.rma_projekat.fragments.SongLikedFragment;
import com.example.rma_projekat.fragments.SongSearchFragment;
import com.example.rma_projekat.interceptors.AuthInterceptor;
import com.example.rma_projekat.models.Song;
import com.example.rma_projekat.services.SongService;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String url = getIntent().getStringExtra("url");
        String token = getIntent().getStringExtra("auth_token");
        String username = getIntent().getStringExtra("username");

        TextView welcomeTextView = findViewById(R.id.welcomeTextView);
        welcomeTextView.setText("Welcome " + username + " <3");

        Fragment songSearchFragment = SongSearchFragment.newInstance(username, token, url);
        Fragment songLikedFragment = SongLikedFragment.newInstance(username, url);

        TabLayout tabLayout = findViewById(R.id.tabLayout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i("TabSelected", tab.getText().toString());

                if(tab.getText().equals("Search")){
                    switchFragment(songSearchFragment);
                }
                else switchFragment(songLikedFragment);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        switchFragment(songSearchFragment);
    }
    void switchFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentFrameLayout, fragment, null)
                .setReorderingAllowed(true)
                .commit();
    }
}