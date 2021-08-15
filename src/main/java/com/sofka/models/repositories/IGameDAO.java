package com.sofka.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sofka.models.entities.Game;

public interface IGameDAO extends CrudRepository<Game, Long>
{

}
