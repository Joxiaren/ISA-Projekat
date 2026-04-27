package com.rudari.isa.models.courses;

import com.rudari.isa.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class MaterialType extends BaseEntity {
    @Column
    private String name;

    @OneToMany(mappedBy = "materialType")
    private List<Material> materials;
}
