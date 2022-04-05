package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Fight;
import com.example.demo.repositories.FightRepository;
@Service
public class FightService {
	final FightRepository fightRepository;
	final FighterService fighterService;
	public FightService(FightRepository fightRepository, FighterService fighterService) {
		this.fightRepository = fightRepository;
		this.fighterService = fighterService;
	}
	public  List<Fight> getAll(){
	    List<Fight> fights = new ArrayList<>();
	    fightRepository.findAll().forEach(fights::add);
	    fights.forEach(fight -> {
	    	fight.fighter = fighterService.getFighterById(fight.id);
	    });
	    return fights;
	}
	
}
