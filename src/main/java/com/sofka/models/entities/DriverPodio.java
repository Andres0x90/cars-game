package com.sofka.models.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="driver_podio")
public class DriverPodio implements Serializable
{
	private static final long serialVersionUID = -3857935060579686140L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	private Driver driver;
	@ManyToOne(fetch = FetchType.LAZY)
	private Podio podio;
	
	private Integer place;
	
	public DriverPodio() 
	{
		
	}
	
	public DriverPodio(Driver driver, Podio podio, Integer place) {
		this.driver = driver;
		this.podio = podio;
		this.place = place;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Podio getPodio() {
		return podio;
	}
	public void setPodio(Podio podio) {
		this.podio = podio;
	}
	public Integer getPlace() {
		return place;
	}
	public void setPlace(Integer place) {
		this.place = place;
	}
	
}
