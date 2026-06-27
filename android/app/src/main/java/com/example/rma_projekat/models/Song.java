package com.example.rma_projekat.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Song {
    @SerializedName("name")
    public String name;
    @SerializedName("url")
    public String url;

    @SerializedName("album")
    public Album album;
    @SerializedName("artist")
    public Artist artist;

    @SerializedName("tags")
    public List<Tag> tags;
    @SerializedName("likes")
    public List<Like> likes;
    @SerializedName("comments")
    public List<Comment> comments;
}
