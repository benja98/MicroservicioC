package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empresas") 
public class Empresas implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	
	//Variables:
	@Id
	private int id;
	
	@Column
	private String empresa;

	
	// Constructores:
	public Empresas(int id, String empresa) {
		super();
		this.id = id;
		this.empresa = empresa;
	}

	public Empresas() {
		super();
	}
	
	
	// Get y set:

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	
	
	
	

}
