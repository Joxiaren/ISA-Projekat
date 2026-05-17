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
}
