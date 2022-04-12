package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Fight;
import com.example.demo.models.Fighter;
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
	public Fight updateFight(Fight fight) {
		Optional<Fight> fightData = fightRepository.findById(fight.id);
		if(fightData.isPresent()) {
			Fight newFight = fightData.get();
			newFight.blue_fighter = fight.blue_fighter;
			newFight.red_fighter = fight.red_fighter;
			newFight.date = fight.date;
			return fightRepository.save(newFight);
		}
		else {
			return null;
		}
	}
	public Fight createFight(Fight fight) {
		return fightRepository.save(fight);
	}
	public Boolean removeFight(Long id) {
		fightRepository.deleteById(id);
		return true;
	}
}
