package com.rudari.isa.models.courses;

import com.rudari.isa.models.BaseEntity;
import com.rudari.isa.models.users.Teacher;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Duty extends BaseEntity {
    @Column
    private LocalDateTime start;
    @Column
    private LocalDateTime end;

    @ManyToOne(optional = false)
    private Session session;
    @ManyToOne(optional = false)
    private RealizedSubject realizedSubject;
    @ManyToOne(optional = false)
    private Teacher teacher;
    @ManyToOne(optional = false)
    private DutyType dutyType;
}
