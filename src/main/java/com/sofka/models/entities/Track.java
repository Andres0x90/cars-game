package com.sofka.models.entities;

import java.util.List;

public class Track 
{
	private Long id;
	private List<Line> lines;
	private Integer km_distance;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Line> getLines() {
		return lines;
	}
	public void setLines(List<Line> lines) {
		this.lines = lines;
	}
	public Integer getKm_distance() {
		return km_distance;
	}
	public void setKm_distance(Integer km_distance) {
		this.km_distance = km_distance;
	}
	
	
}
