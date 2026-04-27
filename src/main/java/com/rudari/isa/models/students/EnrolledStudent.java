package com.rudari.isa.models.students;

import com.rudari.isa.models.BaseEntity;
import com.rudari.isa.models.courses.EvaluationAttempt;
import com.rudari.isa.models.courses.SubjectAttendance;
import com.rudari.isa.models.users.Student;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class EnrolledStudent extends BaseEntity {
    @Column
    private String indexNumber;

    @OneToOne
    @JoinColumn (name = "student")
    private Student student;

    @OneToMany(mappedBy = "enrolledStudent")
    private List<Enrollment> enrollment;
    @OneToMany(mappedBy = "enrolledStudent")
    private List<SubjectAttendance> subjectAttendances;
    @OneToMany(mappedBy = "enrolledStudent")
    private List<EvaluationAttempt> evaluationAttempts;
}
