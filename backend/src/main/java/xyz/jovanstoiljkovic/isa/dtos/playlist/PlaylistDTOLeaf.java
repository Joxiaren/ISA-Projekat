package xyz.jovanstoiljkovic.isa.dtos.playlist;

import xyz.jovanstoiljkovic.isa.dtos.BaseDTO;
import xyz.jovanstoiljkovic.isa.models.Playlist;
import xyz.jovanstoiljkovic.isa.models.Playlist.Visibility;

public class PlaylistDTOLeaf extends BaseDTO<Playlist> {
    private Long id;
    private Visibility visibility;

    public PlaylistDTOLeaf() {
    }

    public PlaylistDTOLeaf(Visibility visibility, Long id) {
        this.visibility = visibility;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }
}
