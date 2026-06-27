package xyz.jovanstoiljkovic.isa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity(name = "like_entity")
public class Like extends BaseEntity{
    @ManyToOne(optional = false)
    private User user;

    public Like() {
    }

    public Like(User user) {
        this.user = user;
    }

    public Like(Long id, User user) {
        super(id);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
