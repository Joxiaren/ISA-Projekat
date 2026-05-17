package xyz.jovanstoiljkovic.isa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity(name = "like_entity")
public class Like extends BaseEntity{
    @ManyToOne(optional = false)
    private User user;
}
