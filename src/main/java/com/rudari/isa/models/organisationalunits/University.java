package com.rudari.isa.models.organisationalunits;

import com.rudari.isa.models.BaseEntity;
import com.rudari.isa.models.address.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.List;

@Entity
public class University extends BaseEntity {
    @Column
    private String name;
    @Column
    private LocalDate foundationDate;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "university")
    private List<College> colleges;
}
