package xyz.jovanstoiljkovic.isa.models;

import jakarta.persistence.Entity;

@Entity
public class Admin extends User{
    @Override
    public String getAuthority() {
        return "ADMIN";
    }
}
