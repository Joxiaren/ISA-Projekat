package com.rudari.isa.models.address;

import com.rudari.isa.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Country extends BaseEntity {
    @Column
    private String name;

    @OneToMany(mappedBy = "country")
    private List<Place> places;
}
