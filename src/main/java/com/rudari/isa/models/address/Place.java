package com.rudari.isa.models.address;

import com.rudari.isa.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Place extends BaseEntity {
    @Column
    private String name;

    @OneToMany(mappedBy = "place")
    private List<Address> address;

    @ManyToOne(optional = false)
    private Country country;

}
