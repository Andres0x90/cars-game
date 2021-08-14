package com.sofka.models.entities;

/* Esta clase no va a ser guardada en la base de datos, ya que a mi parecer la clase *
 * player solo va a funcionar como un alias de los conductores, y unicamente vamos a utilizar
 * y persistir los datos de la clase conductor(Driver)*/

public class Player
{
	private String nombre;
	private Driver driver;
	
	public Player() 
	{
		
	}
	
	public Player(String nombre, Driver driver) 
	{
		this.nombre = nombre;
		this.driver = driver;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	
}
