package xyz.jovanstoiljkovic.isa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Song extends BaseEntity{
    @Column
    private String url;
}
