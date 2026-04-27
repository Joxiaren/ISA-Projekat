package com.rudari.isa.models.organisationalunits;

import com.rudari.isa.models.BaseEntity;
import com.rudari.isa.models.courses.Subject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class StudyYear extends BaseEntity {
    @Column
    private String name;

    @OneToMany(mappedBy = "studyYear")
    private List<SchoolYear> schoolYears;
    @OneToMany(mappedBy = "studyYear")
    private List<Subject> subjects;

    @ManyToOne(optional = false)
    private StudyProgram studyProgram;
}
