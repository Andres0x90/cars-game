package com.sofka.models.entities;

/* Esta clase no va a ser guardada en la base de datos, ya que a mi parecer la clase *
 * player solo va a funcionar como un alias de los conductores, y unicamente vamos a utilizar
 * y persistir los datos de la clase conductor(Driver)*/

public class Player
{
	private String name;
	private Driver driver;
	
	public Player() 
	{
		
	}
	
	public Player(String name, Driver driver) 
	{
		this.name = name;
		this.driver = driver;
	}
	public String getName() {
		return name;
	}
	public void setName(String nombre) {
		this.name = nombre;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	
}
