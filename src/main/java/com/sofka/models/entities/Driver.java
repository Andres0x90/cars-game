package com.sofka.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="drivers")
public class Driver implements Serializable{

	private static final long serialVersionUID = 7845022555736807310L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int wins;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "driver_id")
	private List<Car> car;
	
	@OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
	List<DriverPodio> driver_podio;
	
	public Driver() {

	}
	
	public Driver(String name, int wins) {
		this.name = name;
		this.wins = wins;
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
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public List<Car> getCar() {
		return car;
	}
	public void setCar(List<Car> car) {
		this.car = car;
	}
	public void addCar(Car car) 
	{
		this.car.add(car);
	}
	public List<DriverPodio> getDriver_podio() {
		return driver_podio;
	}
	public void setDriver_podio(List<DriverPodio> driver_podio) {
		this.driver_podio = driver_podio;
	}
	
	
}
