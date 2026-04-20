package com.rudari.isa.models.courses;

import com.rudari.isa.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class SessionMaterial extends BaseEntity {
    @ManyToOne(optional = false)
    private Session session;
    @ManyToOne(optional = false)
    private Material material;
}
