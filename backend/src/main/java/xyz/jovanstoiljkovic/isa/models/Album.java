package xyz.jovanstoiljkovic.isa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Album extends BaseEntity{
    @Column
    private String name;

    @ManyToOne(optional = false)
    private Artist artist;

    @OneToMany(mappedBy = "album")
    private List<Song> songs;
    @OneToMany
    private List<Tag> tags;
    @OneToMany
    private List<Like> likes;
    @OneToMany
    private List<Comment> comments;

    public Album() {
    }

    public Album(String name, Artist artist, List<Song> songs, List<Tag> tags, List<Like> likes, List<Comment> comments) {
        this.name = name;
        this.artist = artist;
        this.songs = songs;
        this.tags = tags;
        this.likes = likes;
        this.comments = comments;
    }

    public Album(Long id, String name, Artist artist, List<Song> songs, List<Tag> tags, List<Like> likes, List<Comment> comments) {
        super(id);
        this.name = name;
        this.artist = artist;
        this.songs = songs;
        this.tags = tags;
        this.likes = likes;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
