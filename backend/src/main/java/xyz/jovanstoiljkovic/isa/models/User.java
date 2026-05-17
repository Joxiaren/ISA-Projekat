package xyz.jovanstoiljkovic.isa.models;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "registered_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity{
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String profilePicture;

    @OneToMany(mappedBy = "commenter")
    private List<Comment> comment;

}
