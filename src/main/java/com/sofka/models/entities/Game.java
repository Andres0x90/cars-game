package com.sofka.models.entities;

public class Game 
{
	private Long id;
	private Track track;
	private Podio podio;

	public Game() 
	{
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public Podio getPodio() {
		return podio;
	}
	public void setPodio(Podio podio) {
		this.podio = podio;
	}
	
	
}
