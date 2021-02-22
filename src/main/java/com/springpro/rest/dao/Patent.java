package com.springpro.rest.dao;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
//@JsonFilter("idFilter")
@Entity(name = "patents")
public class Patent {
	@EmbeddedId PatentID patentID;
	@Column(name= "status")
	String status;
	@Column(name= "patent_expiration_date")
	String patentExpirationDate;
	@Column(name= "center")
	String center;
	@Column(name= "title")
	@NotEmpty
	@Size(min = 1, message = "Title should not be empty")
	String title;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPatent_expiration_date() {
		return patentExpirationDate;
	}
	public void setPatent_expiration_date(String patent_expiration_date) {
		this.patentExpirationDate = patent_expiration_date;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public PatentID getPatentID() {
		return patentID;
	}
	public void setPatentID(PatentID patentID) {
		this.patentID = patentID;
	}
	public String getPatentExpirationDate() {
		return patentExpirationDate;
	}
	public void setPatentExpirationDate(String patentExpirationDate) {
		this.patentExpirationDate = patentExpirationDate;
	}
	
}
