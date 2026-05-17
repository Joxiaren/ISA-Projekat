package xyz.jovanstoiljkovic.isa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Artist extends BaseEntity {
    @Column
    private String name;

    @OneToMany(mappedBy = "artist")
    private List<Song> songs;
    @OneToMany(mappedBy = "artist")
    private List<Album> albums;

    public Artist() {
    }

    public Artist(Long id) {
        super(id);
    }

    public Artist(String name, List<Song> songs, List<Album> albums) {
        this.name = name;
        this.songs = songs;
        this.albums = albums;
    }

    public Artist(Long id, String name, List<Song> songs, List<Album> albums) {
        super(id);
        this.name = name;
        this.songs = songs;
        this.albums = albums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
