package com.rudari.isa.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.Hibernate;

import java.util.Objects;

@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public BaseEntity() {
		super();
	}
	public BaseEntity(Long id) {
		super();
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null)
            return false;
		
		// Bypass lazy loading and fetch actual entity
		obj = Hibernate.unproxy(obj);
		
		if (getClass() != obj.getClass())
            return false;
		
		BaseEntity other = (BaseEntity) obj;
        return id != null && id.equals(other.getId());
	}
	
}
