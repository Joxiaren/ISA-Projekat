package com.rudari.isa.models.courses;

import com.rudari.isa.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Session extends BaseEntity {
    @Column
    private LocalDateTime start;
    @Column
    private LocalDateTime end;

    @OneToMany(mappedBy = "session")
    private List<SessionMaterial> sessionMaterials;
    @OneToMany(mappedBy = "session")
    private List<Duty> teachersOnDuty;

    @ManyToOne(optional = false)
    private SessionType sessionType;
}
