package com.musala.atmosphere.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PHONE_MODEL")
 @NamedQuery(name = "getModelByManufacturerId", query =
 "from PhoneModel model where model.manufacturer.id = :id order by model.name asc")
public class PhoneModel {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NAME", nullable = false)
	private String name;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phoneModel")
	private Set<PhoneModelNumber> modelNumbers = new HashSet<PhoneModelNumber>();
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MANUFACTURER_ID", nullable = false)
	@XmlTransient
	private PhoneManufacturer manufacturer;

	public PhoneModel() {
		// TODO Auto-generated constructor stub
	}

	@XmlAttribute
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	public Set<PhoneModelNumber> getModelNumbers() {
		return modelNumbers;
	}

	public void setModelNumbers(Set<PhoneModelNumber> modelNumbers) {
		this.modelNumbers = modelNumbers;
	}

//	@XmlTransient
//	@JsonIgnore
	public PhoneManufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(PhoneManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "PhoneModel [id=" + id + ", name=" + name + ", manufacturer="
				+ manufacturer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((manufacturer == null) ? 0 : manufacturer.hashCode());
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
		PhoneModel other = (PhoneModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
