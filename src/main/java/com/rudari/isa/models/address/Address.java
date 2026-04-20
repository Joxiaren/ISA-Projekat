package com.rudari.isa.models.address;

import com.rudari.isa.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Address extends BaseEntity {
    @Column
    private String street;
    @Column
    private String number;

    @ManyToOne(optional = false)
    private Place place;
}
