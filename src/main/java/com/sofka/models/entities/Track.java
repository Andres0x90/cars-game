package com.sofka.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tracks")
public class Track implements Serializable
{	

	private static final long serialVersionUID = 711500223166737882L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="track_id")
	private List<Line> lines;
	private Integer km_distance;
	
	public Track(Integer km_distance) 
	{
		lines = new ArrayList<>();
		this.km_distance = km_distance;
	}
	
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
	public void addLine(Line line) 
	{
		this.lines.add(line);
	}
	public Integer getKm_distance() {
		return km_distance;
	}
	public void setKm_distance(Integer km_distance) {
		this.km_distance = km_distance;
	}
	
	
}
