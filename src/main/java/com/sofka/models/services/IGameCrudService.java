package com.sofka.models.services;

import java.util.List;

import com.sofka.models.entities.Driver;

public interface IGameCrudService {
	public List<Driver> listAll();
	public Driver listById(Long id);
	public List<Driver> saveList(List<Driver> drivers);
}
