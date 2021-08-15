package com.sofka.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "driver_id")
	private List<Car> cars;
	
	@OneToMany(mappedBy = "driver", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<DriverPodio> driver_podio;
	
	public Driver() {
		cars = new ArrayList<Car>();
	}
	
	public Driver(String name, int wins) {
		this.name = name;
		this.wins = wins;
		cars = new ArrayList<Car>();
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
	public void addWin() 
	{
		this.wins += 1;
	}
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	public void addCar(Car car) 
	{
		this.cars.add(car);
	}
	public List<DriverPodio> getDriver_podio() {
		return driver_podio;
	}
	public void setDriver_podio(List<DriverPodio> driver_podio) {
		this.driver_podio = driver_podio;
	}
	
	public void addDriver_podio(DriverPodio driver_podio) {
		this.driver_podio.add(driver_podio);
	}
}
