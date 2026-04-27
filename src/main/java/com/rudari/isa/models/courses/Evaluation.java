package com.rudari.isa.models.courses;

import com.rudari.isa.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Evaluation extends BaseEntity {
    @Column
    private LocalDateTime start;
    @Column
    private LocalDateTime end;
    @Column
    private Double points;

    @OneToMany(mappedBy = "evaluation")
    private List<EvaluationAttempt> evaluationAttempts;

    @ManyToOne(optional = false)
    private RealizedSubject realizedSubject;
    @ManyToOne(optional = false)
    private EvaluationType evaluationType;
    @ManyToOne(optional = false)
    private EvaluationInstrument evaluationInstrument;
}
