package com.sofka.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sofka.models.entities.Driver;
import com.sofka.models.entities.Player;
import com.sofka.models.services.IGameCrudService;

@Controller
public class GameController 
{
	@Autowired
	private IGameCrudService gameCS;
	
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
	
	public List<Driver> getDrivers()
	{
		List<Driver> drivers = gameCS.listAll();
		
		if (drivers != null && !drivers.isEmpty()) 
			return drivers;
		else 
			return gameCS.saveList(createDrivers());

	}
	/*public List<Player> createPlayers(String[] players) 
	{
		for (Player player: )
	}*/
	
	@GetMapping({"/", ""})
	public String createGame(Model model) 
	{
		return "create";
	}
	
	@PostMapping("/play")
	public String play(@RequestParam(required=false) String[] players, Model model) 
	{
		model.addAttribute("drivers", getDrivers());
		return "game";
	}
}
