package com.rudari.isa.models.organisationalunits;

import com.rudari.isa.models.BaseEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class College extends BaseEntity {
    @Column
    private String name;

    @OneToOne
    private AdministrativeDuty dean;

    @OneToMany(mappedBy = "college")
    private List<StudyProgram> studyPrograms;

    @ManyToOne(optional = false)
    private University university;

}
