package com.desafio.entities;

import java.util.Date;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tb_paciente")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Integer healthInsuranceCardId;
	@Embedded
	private Endereco address;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	public Patient() {
		
	}

	public Patient(Long id, String name, Integer healthInsuranceCardId, Endereco address, Date createdAt) {
		this.id = id;
		this.name = name;
		this.healthInsuranceCardId = healthInsuranceCardId;
		this.address = address;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHealthInsuranceCardId() {
		return healthInsuranceCardId;
	}

	public void setHealthInsuranceCardId(Integer healthInsuranceCardId) {
		this.healthInsuranceCardId = healthInsuranceCardId;
	}

	public Endereco getAddress() {
		return address;
	}

	public void setAddress(Endereco address) {
		this.address = address;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
	
	
	
	

}
