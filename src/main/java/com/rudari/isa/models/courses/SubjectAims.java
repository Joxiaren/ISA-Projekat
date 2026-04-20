package com.rudari.isa.models.courses;

import com.rudari.isa.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class SubjectAims extends BaseEntity {
    @Column
    private String name;
    @Column
    private String description;
}
