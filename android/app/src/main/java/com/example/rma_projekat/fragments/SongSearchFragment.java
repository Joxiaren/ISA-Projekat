package com.example.rma_projekat.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rma_projekat.R;
import com.example.rma_projekat.SongActivity;
import com.example.rma_projekat.interceptors.AuthInterceptor;
import com.example.rma_projekat.models.Song;
import com.example.rma_projekat.services.SongService;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SongSearchFragment extends Fragment {
    private ViewGroup scrollContent;

    public SongSearchFragment() {
        // Required empty public constructor
    }
    public static SongSearchFragment newInstance(String username, String token, String url) {
        SongSearchFragment fragment = new SongSearchFragment();
        Bundle args = new Bundle();
        args.putString("username", username);
        args.putString("token", token);
        args.putString("url", url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_song_search, container, false);

        Bundle args = getArguments();
        String token = args.getString("token");
        String url = args.getString("url");
        String username = args.getString("username");

        AuthInterceptor authInterceptor = new AuthInterceptor();
        authInterceptor.token = token;

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(authInterceptor)
                .build();

        Retrofit retrofitInstance = new Retrofit.Builder()
                .baseUrl(url)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();

        scrollContent = view.findViewById(R.id.searchScrollContent);

        EditText searchEditText = view.findViewById(R.id.searchEditText);
        Button searchButton = view.findViewById(R.id.searchButton);


        searchButton.setOnClickListener(v -> {
            String searchString = searchEditText.getText().toString();

            SongService songService = retrofitInstance.create(SongService.class);

            Call<List<Song>> call = songService.search(searchString);

            call.enqueue(new Callback<List<Song>>() {
                @Override
                public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                    scrollContent.removeAllViews();
                    if(response.isSuccessful() && response.body() != null){
                        response.body().forEach(song -> {

                            View songView = inflater.inflate(R.layout.song_view, scrollContent, false);

                            TextView nameTextView = songView.findViewById(R.id.nameTextView);
                            TextView albumTextView = songView.findViewById(R.id.albumTextView);
                            TextView likeTextView = songView.findViewById(R.id.likesTextView);

                            nameTextView.setText(song.name);
                            albumTextView.setText(song.album.name);
                            likeTextView.setText(String.valueOf(song.likes.size()));

                            songView.setOnClickListener(v -> {
                                Bundle b = new Bundle();
                                b.putString("songName", song.name);
                                b.putString("albumName", song.album.name);
                                b.putString("songUrl", url + song.url);
                                b.putString("username", username);

                                Intent i = new Intent(v.getContext(), SongActivity.class);
                                i.putExtras(b);

                                startActivity(i);
                            });

                            scrollContent.addView(songView);
                        });
                    }
                }

                @Override
                public void onFailure(Call<List<Song>> call, Throwable throwable) {
                    Log.i("Failure", throwable.getMessage());
                }
            });
        });



        return view;
    }
}