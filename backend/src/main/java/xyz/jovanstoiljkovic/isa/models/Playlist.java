package xyz.jovanstoiljkovic.isa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Playlist extends BaseEntity{
    @Column
    private Visibility visibility;

    @ManyToOne(optional = false)
    private User user;

    @OneToMany
    private List<Song> songs;
    @OneToMany
    private List<Tag> tags;
    @OneToMany
    private List<Like> likes;
    @OneToMany
    private List<Comment> comments;

    public enum Visibility{
        PUBLIC,
        PRIVATE
    }

    public Playlist() {
    }

    public Playlist(Visibility visibility, User user, List<Song> songs, List<Tag> tags, List<Like> likes, List<Comment> comments) {
        this.visibility = visibility;
        this.user = user;
        this.songs = songs;
        this.tags = tags;
        this.likes = likes;
        this.comments = comments;
    }

    public Playlist(Long id, Visibility visibility, User user, List<Song> songs, List<Tag> tags, List<Like> likes, List<Comment> comments) {
        super(id);
        this.visibility = visibility;
        this.user = user;
        this.songs = songs;
        this.tags = tags;
        this.likes = likes;
        this.comments = comments;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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


