package xyz.jovanstoiljkovic.isa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Comment extends BaseEntity{
    @Column
    private String content;

    @Column
    private LocalDateTime posted;

    @ManyToOne(optional = false)
    private User commenter;

    public Comment() {
    }

    public Comment(String content, LocalDateTime posted, User commenter) {
        this.content = content;
        this.posted = posted;
        this.commenter = commenter;
    }

    public Comment(Long id, String content, LocalDateTime posted, User commenter) {
        super(id);
        this.content = content;
        this.posted = posted;
        this.commenter = commenter;
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

    public User getCommenter() {
        return commenter;
    }

    public void setCommenter(User commenter) {
        this.commenter = commenter;
    }
}
