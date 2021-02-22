package com.springpro.rest.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PatentID implements Serializable{
	@Column(name="patent_number")
	String patentNumber;
	@Column(name="application_sn")
	String applicationSN;
	@Column(name="case_number")
	String caseNumber;
	public String getPatent_number() {
		return patentNumber;
	}
	public void setPatent_number(String patent_number) {
		this.patentNumber = patent_number;
	}
	public String getApplication_sn() {
		return applicationSN;
	}
	public void setApplication_sn(String application_sn) {
		this.applicationSN = application_sn;
	}
	public String getCase_number() {
		return caseNumber;
	}
	public void setCase_number(String case_number) {
		this.caseNumber = case_number;
	}
	public PatentID(String patentNumber, String applicationSN, String caseNumber) {
		super();
		this.patentNumber = patentNumber;
		this.applicationSN = applicationSN;
		this.caseNumber = caseNumber;
	}
	public PatentID() {
	}
}
