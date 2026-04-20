package com.rudari.isa.models.courses;

import com.rudari.isa.models.BaseEntity;
import com.rudari.isa.models.organisationalunits.StudyYear;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Subject extends BaseEntity {
    @Column
    private String name;
    @Column
    private Integer ESPB;
    @Column
    private boolean required;
    @Column
    private Integer numberOfLectures;
    @Column
    private Integer numberOfExerciseSessions;
    @Column
    private Integer numberOfOtherSessions;
    @Column
    private Integer numberOfResearchSessions;

    @OneToMany
    private List<SubjectAims> subjectAims;
    @OneToMany
    private List<SubjectGoals> subjectGoals;
    @OneToMany
    private List<SubjectStructure> subjectStructure;
    @OneToMany(mappedBy = "subject")
    private List<RealizedSubject> realizedSubjects;

    @ManyToOne(optional = false)
    private StudyYear studyYear;
}
