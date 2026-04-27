package com.rudari.isa.models.organisationalunits;

import com.rudari.isa.models.BaseEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class StudyProgram extends BaseEntity {
    @Column
    private String name;

    @OneToOne
    private AdministrativeDuty programManager;

    @OneToMany(mappedBy = "studyProgram")
    private List<StudyYear> studyYear;

    @ManyToOne(optional = false)
    private College college;
}
