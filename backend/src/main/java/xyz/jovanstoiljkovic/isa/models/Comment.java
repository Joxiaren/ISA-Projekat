package xyz.jovanstoiljkovic.isa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment extends BaseEntity{
    @Column
    private String content;

    @ManyToOne(optional = false)
    private User commenter;
}
