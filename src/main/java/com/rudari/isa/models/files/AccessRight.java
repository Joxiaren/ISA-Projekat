package com.rudari.isa.models.files;

import com.rudari.isa.models.BaseEntity;
import com.rudari.isa.models.users.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class AccessRight extends BaseEntity {
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime deletedAt;

    @ManyToOne(optional = false)
    private User owner;
    @ManyToOne(optional = false)
    private File file;
}
