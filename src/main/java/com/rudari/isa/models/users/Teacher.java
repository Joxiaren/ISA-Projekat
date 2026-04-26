package com.rudari.isa.models.users;

import com.rudari.isa.models.courses.Duty;
import com.rudari.isa.models.faculty.Title;
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
    private List<Duty> duties;
    @OneToMany(mappedBy = "teacher")
    private List<AdministrativeDuty> administrativeDuties;
    @OneToMany(mappedBy = "teacher")
    private List<Title> titles;
}
