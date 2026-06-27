package xyz.jovanstoiljkovic.isa.dtos.like;

import xyz.jovanstoiljkovic.isa.dtos.BaseDTO;
import xyz.jovanstoiljkovic.isa.models.Like;

public class LikeDTOLeaf extends BaseDTO<Like> {
    private Long id;

    public LikeDTOLeaf() {
    }

    public LikeDTOLeaf(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
