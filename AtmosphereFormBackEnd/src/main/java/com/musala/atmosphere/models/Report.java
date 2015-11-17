package com.musala.atmosphere.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.NamedQuery;

@Entity
@XmlRootElement(name = "report")
@NamedQuery(name = "getUsedModelNumbers", query = "select distinct report.phoneModelNumber from Report report where report.author like :author order by report.phoneModelNumber.name asc")
public class Report {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ANDROID_ID", nullable = false)
	private Android android;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PHONE_MODEL_NUMBER_ID", nullable = false)
	private PhoneModelNumber phoneModelNumber;
	@Column(name = "STEPS_TO_REPRODUCE", nullable = false)
	private String stepsToReproduce;
	@Column(name = "EXPECTED_RESULT", nullable = false)
	private String expectedResult;
	@Column(name = "ACTUAL_RESULT", nullable = false)
	private String actualResult;
	@Column(name = "APP_NAME", nullable = false)
	private String application;
	@Column(name = "APP_VERSION", nullable = false)
	private String appVersion;
	@Column(name = "APP_URL", nullable = false)
	private String appURL;
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	@Column(name = "AUTHOR", nullable = false)
	private String author;
	@Column(name = "VIDEO_FILE", nullable = false)
	private String videoFile;

	@XmlAttribute
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Android getAndroid() {
		return android;
	}

	public void setAndroid(Android android) {
		this.android = android;
	}

	public PhoneModelNumber getPhoneModelNumber() {
		return phoneModelNumber;
	}

	public void setPhoneModelNumber(PhoneModelNumber phoneModelNumber) {
		this.phoneModelNumber = phoneModelNumber;
	}

	public String getStepsToReproduce() {
		return stepsToReproduce;
	}

	public void setStepsToReproduce(String stepsToReproduce) {
		this.stepsToReproduce = stepsToReproduce;
	}

	public String getExpectedResult() {
		return expectedResult;
	}

	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}

	public String getActualResult() {
		return actualResult;
	}

	public void setActualResult(String actualResult) {
		this.actualResult = actualResult;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getAppURL() {
		return appURL;
	}

	public void setAppURL(String appURL) {
		this.appURL = appURL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Report [id=" + id + ", android=" + android
				+ ", phoneModelNumber=" + phoneModelNumber
				+ ", stepsToReproduce=" + stepsToReproduce
				+ ", expectedResult=" + expectedResult + ", actualResult="
				+ actualResult + ", application=" + application
				+ ", appVersion=" + appVersion + ", appURL=" + appURL
				+ ", description=" + description + ", author=" + author
				+ ", videoFile=" + videoFile + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((actualResult == null) ? 0 : actualResult.hashCode());
		result = prime * result + ((android == null) ? 0 : android.hashCode());
		result = prime * result + ((appURL == null) ? 0 : appURL.hashCode());
		result = prime * result
				+ ((appVersion == null) ? 0 : appVersion.hashCode());
		result = prime * result
				+ ((application == null) ? 0 : application.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((expectedResult == null) ? 0 : expectedResult.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((phoneModelNumber == null) ? 0 : phoneModelNumber.hashCode());
		result = prime
				* result
				+ ((stepsToReproduce == null) ? 0 : stepsToReproduce.hashCode());
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
		Report other = (Report) obj;
		if (actualResult == null) {
			if (other.actualResult != null)
				return false;
		} else if (!actualResult.equals(other.actualResult))
			return false;
		if (android == null) {
			if (other.android != null)
				return false;
		} else if (!android.equals(other.android))
			return false;
		if (appURL == null) {
			if (other.appURL != null)
				return false;
		} else if (!appURL.equals(other.appURL))
			return false;
		if (appVersion == null) {
			if (other.appVersion != null)
				return false;
		} else if (!appVersion.equals(other.appVersion))
			return false;
		if (application == null) {
			if (other.application != null)
				return false;
		} else if (!application.equals(other.application))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (expectedResult == null) {
			if (other.expectedResult != null)
				return false;
		} else if (!expectedResult.equals(other.expectedResult))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (phoneModelNumber == null) {
			if (other.phoneModelNumber != null)
				return false;
		} else if (!phoneModelNumber.equals(other.phoneModelNumber))
			return false;
		if (stepsToReproduce == null) {
			if (other.stepsToReproduce != null)
				return false;
		} else if (!stepsToReproduce.equals(other.stepsToReproduce))
			return false;
		return true;
	}

	public String getVideoFile() {
		return videoFile;
	}

	public void setVideoFile(String videoFile) {
		this.videoFile = videoFile;
	}

}
