package xyz.jovanstoiljkovic.isa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Song extends BaseEntity{
    @Column
    private String name;
    @Column
    private String url;

    @ManyToOne(optional = true)
    private Album album;
    @ManyToOne(optional = false)
    private Artist artist;

    @OneToMany()
    private List<Tag> tags;
    @OneToMany()
    private List<Like> likes;
    @OneToMany()
    private List<Comment> comments;

    public Song() {
    }

    public Song(String name, String url, Album album, Artist artist, List<Tag> tags, List<Like> likes, List<Comment> comments) {
        this.name = name;
        this.url = url;
        this.album = album;
        this.artist = artist;
        this.tags = tags;
        this.likes = likes;
        this.comments = comments;
    }

    public Song(Long id, String name, String url, Album album, Artist artist, List<Tag> tags, List<Like> likes, List<Comment> comments) {
        super(id);
        this.name = name;
        this.url = url;
        this.album = album;
        this.artist = artist;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
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
