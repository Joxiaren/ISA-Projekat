package com.rudari.isa.models.faculty;

import com.rudari.isa.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Title extends BaseEntity {
    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;

    @OneToMany
    private List<ScientificField> scientificFields;
    @OneToMany
    private List<TitleType> titleTypes;

}
