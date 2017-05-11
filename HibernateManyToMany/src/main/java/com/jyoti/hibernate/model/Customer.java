package com.jyoti.hibernate.model;

import java.util.Set;

public class Customer {
	
	private long id;

	private String name;
	private String address;
	
	private Set<Branch> branches;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Branch> getBranches() {
		return branches;
	}

	public void setBranches(Set<Branch> branches) {
		this.branches = branches;
	}


}
