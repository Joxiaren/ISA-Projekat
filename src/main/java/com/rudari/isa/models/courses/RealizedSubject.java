package com.rudari.isa.models.courses;

import com.rudari.isa.models.BaseEntity;
import com.rudari.isa.models.organisationalunits.SchoolYear;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class RealizedSubject extends BaseEntity {
    @ManyToOne(optional = false)
    private Subject subject;
    @ManyToOne(optional = false)
    private SchoolYear schoolYear;

    @OneToMany(mappedBy = "realizedSubject")
    private List<Session> sessions;
    @OneToMany(mappedBy = "realizedSubject")
    private List<Material> materials;
    @OneToMany(mappedBy = "realizedSubject")
    private List<Duty> duties;
    @OneToMany(mappedBy = "realizedSubject")
    private List<SubjectAttendance> subjectAttendances;
    @OneToMany(mappedBy = "realizedSubject")
    private List<Evaluation> evaluations;
}
