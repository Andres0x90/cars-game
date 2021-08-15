package com.sofka.models.services;

import java.util.List;

import com.sofka.models.entities.Driver;
import com.sofka.models.entities.Game;
import com.sofka.models.entities.Player;

public interface IGameCrudService {
	public List<Driver> listAll();
	public Driver listById(Long id);
	public Driver listDriverByName(String name);
	public Driver saveDriver(Driver driver);
	public List<Driver> saveDrivers(List<Driver> drivers);
	public Game saveGame(Game game);
	public List<Driver>createDrivers();
	public List<Driver> getDrivers();
	public List<Player> createPlayers(String[] players);
	public Game createGame(Integer km_distance);
	public void setWinners(String[] drivers, Game game);
}
