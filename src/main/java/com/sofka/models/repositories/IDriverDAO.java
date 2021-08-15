package com.sofka.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sofka.models.entities.Driver;

public interface IDriverDAO extends CrudRepository<Driver, Long>
{
	public Driver findByName(String name);
}
