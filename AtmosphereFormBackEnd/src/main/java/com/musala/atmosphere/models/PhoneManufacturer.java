package com.musala.atmosphere.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PHONE_MANUFACTURER")
public class PhoneManufacturer {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "name", nullable = false)
	private String name;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "manufacturer")
	private Set<PhoneModel> models = new HashSet<PhoneModel>();

	public PhoneManufacturer() {
		// TODO Auto-generated constructor stub
	}

	@XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlTransient
	@JsonIgnore
	public Set<PhoneModel> getModels() {
		return models;
	}

	public void setModels(Set<PhoneModel> models) {
		this.models = models;
	}

	@Override
	public String toString() {
		return "PhoneManufacturer [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneManufacturer other = (PhoneManufacturer) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	

}
