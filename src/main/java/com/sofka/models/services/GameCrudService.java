package com.sofka.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofka.models.entities.Car;
import com.sofka.models.entities.Driver;
import com.sofka.models.entities.DriverPodio;
import com.sofka.models.entities.Game;
import com.sofka.models.entities.Line;
import com.sofka.models.entities.Player;
import com.sofka.models.entities.Podio;
import com.sofka.models.entities.Track;
import com.sofka.models.repositories.IDriverDAO;
import com.sofka.models.repositories.IGameDAO;

@Service
public class GameCrudService implements IGameCrudService{

	@Autowired
	private IDriverDAO driverDAO;
	
	@Autowired
	private IGameDAO gameDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Driver> listAll() {
		return (List<Driver>) driverDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Driver listById(Long id) {
		return driverDAO.findById(id).orElse(null);
	}
	@Override
	@Transactional(readOnly = true)
	public Driver listDriverByName(String name) {
		return driverDAO.findByName(name);
	}
	@Override
	@Transactional
	public Driver saveDriver(Driver driver) {
		return driverDAO.save(driver);
	}
	@Override
	@Transactional
	public List<Driver> saveDrivers(List<Driver> drivers) {
		return (List<Driver>) driverDAO.saveAll(drivers);
	}
	
	@Override
	@Transactional
	public Game saveGame(Game game) {
		return gameDAO.save(game);
	}


	@Override
	public List<Driver>createDrivers()
	{
		List<Driver> drivers = new ArrayList<>();
		drivers.add(new Driver("Mario", 0));
		drivers.add(new Driver("Luigi", 0));
		drivers.add(new Driver("Yoshi", 0));
		drivers.add(new Driver("Pieck", 0));
		drivers.add(new Driver("Kira", 0));
		
		return drivers;
	}

	@Override
	@Transactional
	public List<Driver> getDrivers()
	{
		List<Driver> drivers = listAll();
		
		if (drivers != null && !drivers.isEmpty()) 
			return drivers;
		else 
			return saveDrivers(createDrivers());

	}

	@Override
	public List<Player> createPlayers(String[] players) 
	{
		List<Player> playersList = new ArrayList<>();
		List<Driver> drivers = listAll();
		
		for (int i=0; i<drivers.size(); i++) 
			playersList.add(new Player(players[i], drivers.get(i)));
		
		return playersList;
	}

	@Override
	@Transactional
	public Game createGame(Integer km_distance)
	{
		List<Driver> drivers = getDrivers();
		Track track = new Track(km_distance);
		
		for (Driver driver: drivers)
		{
			Car car = new Car();
			driver.addCar(car);
			driver = saveDriver(driver);
			car = driver.getCars().get(driver.getCars().size() - 1);
			
			Line line = new Line(car);
			track.addLine(line);
		}
		
		Game game = new Game(track, new Podio());		
		return saveGame(game);
	}

	@Override
	@Transactional
	public void setWinners(String[] drivers, Game game) 
	{
		for (int i=0; i<drivers.length; i++) 
		{
			Driver driver = listDriverByName(drivers[i]);
			DriverPodio driverPodio = new DriverPodio(driver, game.getPodio(), i+1);
			driver.addDriver_podio(driverPodio);
			driver.addWin();
			saveDriver(driver);
		}
	}
}
