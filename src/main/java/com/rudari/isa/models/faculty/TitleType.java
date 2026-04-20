package com.rudari.isa.models.faculty;

import com.rudari.isa.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class TitleType extends BaseEntity {
    @Column
    private String name;
}
