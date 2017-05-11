package com.jyoti.hibernate.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "BRANCHANNO")
public class BranchAnno {
	
	@Id
	@Column(name = "branch_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "branch_address")
	private String address;
	
	@Column(name = "branch_email")
	private String email;
	
	@ManyToMany(targetEntity = CustomerAnno.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "BRANCH_CUSTOMERS", 
				joinColumns = { @JoinColumn(name = "branch_id") }, 
				inverseJoinColumns = { @JoinColumn(name = "cust_id") })
	private Set<CustomerAnno> customerAnnos;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<CustomerAnno> getCustomerAnno() {
		return customerAnnos;
	}

	public void setCustomerAnno(Set<CustomerAnno> customerAnnos) {
		this.customerAnnos = customerAnnos;
	}

}
