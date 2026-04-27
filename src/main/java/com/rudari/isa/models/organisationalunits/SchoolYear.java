package com.rudari.isa.models.organisationalunits;

import com.rudari.isa.models.BaseEntity;
import com.rudari.isa.models.courses.RealizedSubject;
import com.rudari.isa.models.students.Enrollment;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
public class SchoolYear extends BaseEntity {
    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;

    @OneToMany(mappedBy = "schoolYear")
    private List<Enrollment> enrollments;
    @OneToMany(mappedBy = "schoolYear")
    private List<RealizedSubject> realizedSubjects;

    @ManyToOne(optional = false)
    private StudyYear studyYear;
}
