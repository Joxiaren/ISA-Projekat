package com.rudari.isa.models.courses;

import com.rudari.isa.models.BaseEntity;
import com.rudari.isa.models.students.EnrolledStudent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class SubjectAttendance extends BaseEntity {
    @Column
    private Integer finalGrade;

    @ManyToOne(optional = false)
    private EnrolledStudent enrolledStudent;
    @ManyToOne(optional = false)
    private RealizedSubject realizedSubject;
}
