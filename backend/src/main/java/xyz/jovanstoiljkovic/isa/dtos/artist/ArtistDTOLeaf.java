package xyz.jovanstoiljkovic.isa.dtos.artist;

import xyz.jovanstoiljkovic.isa.dtos.BaseDTO;
import xyz.jovanstoiljkovic.isa.models.Artist;

public class ArtistDTOLeaf extends BaseDTO<Artist> {
    private Long id;
    private String name;

    public ArtistDTOLeaf() {
    }

    public ArtistDTOLeaf(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
