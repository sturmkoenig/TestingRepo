package com.airhacks.entities;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "FINANCES_USER")
//TODO: change from json to xml 
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	@XmlTransient
	private Long userId;

	@Column(name = "FIRST_NAME")
	@NotBlank(message = "First name cannot be blank")
	@XmlTransient
	private String firstName;

	@Column(name = "LAST_NAME")
	@XmlTransient
	private String lastName;

	@Column(name = "BIRTH_DATE")
	@JsonbDateFormat(value = "dd/MM/yy")
	@XmlTransient
	@Past
	private LocalDate birthDate;

	@Column(name = "EMAIL_ADDRESS")
	@NotBlank(message = "Please provide mail address")
	@Email(message = "Please provide valid mail address")
	@XmlTransient
	private String emailAddress;

	@Column(name = "CITY")
	@XmlTransient
	private String city;

	@Column(name = "CREATED_BY")
	@XmlTransient
	private String createdBy;

	@Column(name = "CREATED_DATE")
	@XmlTransient
	@JsonbDateFormat(value = "dd/MM/yy")
	private LocalDate createdDate;

	@Column(name = "LAST_UPDATED_DATE")
	@JsonbDateFormat(value = "dd/MM/yy")
	@XmlTransient
	private LocalDate lastUpdatedDate;

	@Column(name = "LAST_UPDATED_BY")
	@XmlTransient
	private String lastUpdatedBy;

	@XmlTransient
	private String socialSecurityNumber;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public LocalDate getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(LocalDate lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}
