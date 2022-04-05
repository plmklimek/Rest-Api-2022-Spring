package com.example.demo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Fight;
import com.example.demo.models.Fighter;
import com.example.demo.repositories.FighterRepository;
import com.example.demo.services.FightService;
import com.example.demo.services.FighterService;

@RestController
public class MainController {

	final FighterService fighterService;
	final FightService fightService;
	public MainController(FighterService fighterService, FightService fightService){
		this.fighterService = fighterService;
		this.fightService = fightService;
	}
	@GetMapping(path="/getfighters")
	public  List<Fighter> getAllFighters() {
		return fighterService.getAll();	
	}
	@GetMapping(path="/getfights")
	public  List<Fight> getAllFights() {
		return fightService.getAll();
		
	}

}
