package com.rudari.isa.models.students;

import com.rudari.isa.models.BaseEntity;
import com.rudari.isa.models.organisationalunits.SchoolYear;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrollment extends BaseEntity {
    @Column
    private Integer numberOfEnrollment;

    @ManyToOne(optional = false)
    private SchoolYear schoolYear;
    @ManyToOne(optional = false)
    private EnrolledStudent enrolledStudent;
}
