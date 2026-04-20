package com.rudari.isa.models.users;

import com.rudari.isa.models.organisationalunits.AdministrativeDuty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Teacher extends User {
    @Column
    private String biography;

    @OneToMany(mappedBy = "teacher")
    private List<AdministrativeDuty> administrativeDuties;
}
