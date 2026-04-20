package com.rudari.isa.models.organisationalunits;

import com.rudari.isa.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class College extends BaseEntity {
    @Column
    private String name;

    @OneToOne
    private AdministrativeDuty dean;

    @OneToMany(mappedBy = "college")
    private List<StudyProgram> studyPrograms;

}
