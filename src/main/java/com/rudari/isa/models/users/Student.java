package com.rudari.isa.models.users;

import com.rudari.isa.models.address.Address;
import com.rudari.isa.models.students.EnrolledStudent;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class Student extends User {
    @OneToOne
    private Address address;

    @OneToOne(mappedBy = "student")
    private EnrolledStudent enrolledStudent;
}
