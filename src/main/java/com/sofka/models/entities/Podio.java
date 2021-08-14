package com.sofka.models.entities;

import java.util.List;

public class Podio {
	private List<Player> results;
	
	public Podio() 
	{
		
	}

	public List<Player> getResults() {
		return results;
	}

	public void setResults(List<Player> results) {
		this.results = results;
	}

	
	public void addWinner(Player player) 
	{
		results.add(player);
	}
}
