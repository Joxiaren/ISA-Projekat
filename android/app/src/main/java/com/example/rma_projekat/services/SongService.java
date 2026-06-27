package com.example.rma_projekat.services;

import com.example.rma_projekat.models.Song;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SongService {
    @GET("/api/song/search")
    Call<List<Song>> search(@Query("s") String searchString);
}
