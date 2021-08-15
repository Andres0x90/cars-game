package com.sofka.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofka.models.entities.Driver;
import com.sofka.models.repositories.IDriverDAO;

@Service
public class GameCrudService implements IGameCrudService{

	@Autowired
	private IDriverDAO driverDAO;
	
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
	@Transactional
	public List<Driver> saveList(List<Driver> drivers) {
		return (List<Driver>) driverDAO.saveAll(drivers);
	}

}
