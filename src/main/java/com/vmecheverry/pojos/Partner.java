package com.vmecheverry.pojos;

import java.util.ArrayList;
import java.util.List;

public class Partner {
	
	
	private String branch;
	private List<Partner> branches;
	private String acronym;
	private String name;
	private String type;
	private String country;
	private String city;
	private String website;
	
	public Partner() {
		branches= new ArrayList<Partner>();
	}
	

	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public List<Partner> getBranches() {
		return branches;
	}
	public void setBranches(List<Partner> branches) {
		this.branches = branches;
	}
	public String getAcronym() {
		return acronym;
	}
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
}
