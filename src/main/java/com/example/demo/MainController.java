package com.example.demo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping(path = "/getfighters")
	public  List<Fighter> getAllFighters() {
		return fighterService.getAll();	
	}
	@GetMapping(path = "/getfights")
	public  List<Fight> getAllFights() {
		return fightService.getAll();
	}
	@RequestMapping(value = "/putfighter/{id}", method = RequestMethod.PUT, consumes = {"multipart/form-data"})
	public Fighter updateFighter(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("age") int age) {
		Fighter fighter = new Fighter(id, name, surname, age);
		return fighterService.updateFighter(fighter);
	}

}
