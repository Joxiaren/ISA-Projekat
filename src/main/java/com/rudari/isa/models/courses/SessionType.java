package com.rudari.isa.models.courses;

import com.rudari.isa.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class SessionType extends BaseEntity {
    @Column
    private String name;

    @OneToMany(mappedBy = "sessionType")
    private List<Session> sessions;
}
