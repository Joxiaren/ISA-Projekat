package com.rudari.isa.models.organisationalunits;

import com.rudari.isa.models.BaseEntity;
import com.rudari.isa.models.users.Teacher;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class AdministrativeDuty extends BaseEntity {
    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;

    @ManyToOne(optional = false)
    private Teacher teacher;

}
