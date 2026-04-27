package com.rudari.isa.models.courses;

import com.rudari.isa.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class EvaluationInstrument extends BaseEntity {
    @Column
    private String name;

    @OneToMany
    private List<Material> materials;
}
