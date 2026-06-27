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
}
