package com.rudari.isa.models.organisationalunits;

import com.rudari.isa.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class StudyProgram extends BaseEntity {
    @Column
    private String name;

    @OneToOne
    private AdministrativeDuty programManager;

    @ManyToOne(optional = false)
    private College college;
}
