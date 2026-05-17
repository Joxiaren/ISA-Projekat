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
}
