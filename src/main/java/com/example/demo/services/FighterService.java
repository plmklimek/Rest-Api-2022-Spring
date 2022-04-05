package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Fighter;
import com.example.demo.repositories.FighterRepository;

@Service
public class FighterService {

	final FighterRepository fighterRepository;
	public FighterService(FighterRepository fighterRepository){
		this.fighterRepository = fighterRepository;
	}
	public  List<Fighter> getAll(){
	    List<Fighter> fighters = new ArrayList<>();
	    fighterRepository.findAll().forEach(fighters::add);
	    return fighters;
	}
	public Fighter getFighterById(Long id) {
		Optional<Fighter> fighter = fighterRepository.findById(id);
		if(fighter.isPresent()) {
			return fighter.get();
		}	
		else {
			return null;
		}
	}
}
