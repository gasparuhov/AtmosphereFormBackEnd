package com.musala.atmosphere.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "PHONE_MODEL_NUMBER")
@NamedQuery(name = "getModelNumberByModelId", query = "from PhoneModelNumber number where number.phoneModel.id = :id order by number.name asc")
public class PhoneModelNumber {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NAME", nullable = false)
	private String name;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PHONE_MODEL_ID", nullable = false)
	private PhoneModel phoneModel;

	public PhoneModelNumber() {
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

//	@XmlTransient
//	@JsonIgnore
	public PhoneModel getPhoneModel() {
		return phoneModel;
	}

	public void setPhoneModel(PhoneModel phoneModel) {
		this.phoneModel = phoneModel;
	}

	@Override
	public String toString() {
		return "PhoneModelNumber [id=" + id + ", name=" + name
				+ ", phoneModel=" + phoneModel + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((phoneModel == null) ? 0 : phoneModel.hashCode());
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
		PhoneModelNumber other = (PhoneModelNumber) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneModel == null) {
			if (other.phoneModel != null)
				return false;
		} else if (!phoneModel.equals(other.phoneModel))
			return false;
		return true;
	}

}
