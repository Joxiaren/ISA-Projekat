package xyz.jovanstoiljkovic.isa.dtos.album;

import xyz.jovanstoiljkovic.isa.dtos.BaseDTO;
import xyz.jovanstoiljkovic.isa.models.Album;

public class AlbumDTOLeaf extends BaseDTO<Album> {
    private Long id;
    private String name;

    public AlbumDTOLeaf() {
    }

    public AlbumDTOLeaf(Long id, String name) {
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
