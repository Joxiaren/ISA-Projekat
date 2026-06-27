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
}


