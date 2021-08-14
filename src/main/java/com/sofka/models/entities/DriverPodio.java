package com.sofka.models.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="driver_podio")
public class DriverPodio implements Serializable
{
	private static final long serialVersionUID = -3857935060579686140L;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	private Driver driver;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	private Podio podio;
	
	private Integer place;
	
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
