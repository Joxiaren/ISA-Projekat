package com.rudari.isa.models.courses;

import com.rudari.isa.models.BaseEntity;
import com.rudari.isa.models.files.File;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Material extends BaseEntity {
    @Column
    private String name;
    @Column
    private String description;

    @OneToMany(mappedBy = "material")
    private List<SessionMaterial> sessionMaterials;

    @ManyToOne
    private File file;
    @ManyToOne
    private MaterialType materialType;
    @ManyToOne
    private RealizedSubject realizedSubject;
}
