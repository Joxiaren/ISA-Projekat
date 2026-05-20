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

    @OneToMany(mappedBy = "user")
    private List<Playlist> playlists;
    @OneToMany(mappedBy = "commenter")
    private List<Comment> comment;

    public User() {
    }

    public User(Long id) {
        super(id);
    }

    public User(String name, String surname, String email, String username, String password, String profilePicture, List<Comment> comment) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
        this.comment = comment;
    }

    public User(Long id, String name, String surname, String email, String username, String password, String profilePicture, List<Comment> comment) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getAuthority() {
        return "USER";
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
