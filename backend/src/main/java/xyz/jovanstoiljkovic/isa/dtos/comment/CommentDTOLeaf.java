package xyz.jovanstoiljkovic.isa.dtos.comment;

import xyz.jovanstoiljkovic.isa.dtos.BaseDTO;
import xyz.jovanstoiljkovic.isa.models.Comment;

import java.time.LocalDateTime;

public class CommentDTOLeaf extends BaseDTO<Comment> {
    private Long id;
    private String content;
    private LocalDateTime posted;

    public CommentDTOLeaf() {
    }

    public CommentDTOLeaf(Long id, String content, LocalDateTime posted) {
        this.id = id;
        this.content = content;
        this.posted = posted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPosted() {
        return posted;
    }

    public void setPosted(LocalDateTime posted) {
        this.posted = posted;
    }
}
