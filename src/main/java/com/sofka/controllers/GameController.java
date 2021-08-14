package com.sofka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController 
{
	@GetMapping({"/", ""})
	public String createGame(@RequestParam(required = false) Integer players,Model model) 
	{
		model.addAttribute("players",players);
		return "create";
	}
	
	@PostMapping("play")
	public String play() 
	{
		
		return "game";
	}
}
