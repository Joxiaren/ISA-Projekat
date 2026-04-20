package com.rudari.isa.models.files;

import com.rudari.isa.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.net.URL;
import java.util.List;

@Entity
public class File extends BaseEntity {
    @Column
    private String filename;
    @Column
    private String description;
    @Column
    private URL url;

    @OneToMany(mappedBy = "file")
    private List<AccessRight> accessRights;
}
