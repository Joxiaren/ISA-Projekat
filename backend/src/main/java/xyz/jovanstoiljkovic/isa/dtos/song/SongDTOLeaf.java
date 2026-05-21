package xyz.jovanstoiljkovic.isa.dtos.song;

import xyz.jovanstoiljkovic.isa.dtos.BaseDTO;
import xyz.jovanstoiljkovic.isa.models.Song;

public class SongDTOLeaf extends BaseDTO<Song> {
    private Long id;
    private String name;
    private String url;

    public SongDTOLeaf() {
    }

    public SongDTOLeaf(Long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
