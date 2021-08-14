package com.sofka.models.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="podios")
public class Podio implements Serializable
{
	private static final long serialVersionUID = 3969529265844701125L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	@OneToMany(mappedBy = "podio",fetch = FetchType.LAZY)
	private List<DriverPodio> driver_podio;
	
	public Podio() 
	{
		
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<DriverPodio> getResults() {
		return driver_podio;
	}

	public void setResults(List<DriverPodio> driver_podio) {
		this.driver_podio = driver_podio;
	}


	public List<DriverPodio> getDriver_podio() {
		return driver_podio;
	}


	public void setDriver_podio(List<DriverPodio> driver_podio) {
		this.driver_podio = driver_podio;
	}

}
