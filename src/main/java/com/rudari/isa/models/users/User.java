package com.rudari.isa.models.users;

import com.rudari.isa.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "registered_user")
public class User extends BaseEntity {
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String jmbg;
    @Column
    private String username;
    @Column
    private String password;
}
