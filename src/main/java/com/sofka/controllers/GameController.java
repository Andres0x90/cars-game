package com.sofka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sofka.models.entities.Game;
import com.sofka.models.services.IGameCrudService;

@Controller
@SessionAttributes("game")
public class GameController 
{
	@Autowired
	private IGameCrudService gameCS;
	
	@GetMapping({"/", ""})
	public String createGame(Model model) 
	{
		return "create";
	}
	
	@PostMapping("/play")
	public String play(@RequestParam String[] players,@RequestParam String distance,
			Model model) 
	{
		model.addAttribute("drivers", gameCS.getDrivers());
		model.addAttribute("players", gameCS.createPlayers(players));
		model.addAttribute("distance", distance);
		model.addAttribute("game", gameCS.createGame(Integer.parseInt(distance)));
		return "game";
	}
	@PostMapping("/finish")
	public String finish(@RequestParam String[] places,Game game, Model model, SessionStatus status) 
	{
		gameCS.setWinners(places, game);
		status.setComplete();
		return "redirect:/";
	}
}
