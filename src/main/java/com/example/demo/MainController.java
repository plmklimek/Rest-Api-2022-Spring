package com.example.demo;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	@RequestMapping(value = "putfights/{id}", method = RequestMethod.PUT, consumes = {"multipart/form-data"})
	public Fight updateFights(@RequestParam("id") Long id, @RequestParam("id_blue") int blue_id, @RequestParam("id_red") int red_id, @RequestParam("date") String dateString) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = dateFormat.parse(dateString);
		Fight fight = new Fight(id, blue_id, red_id, date);
		return fightService.updateFight(fight);
	}
	@RequestMapping(value = "/createfighter", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public Fighter newFighter(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("age") int age) {
		Fighter fighter = new Fighter(name, surname, age);
		return fighterService.createFighter(fighter);
	}
	@RequestMapping(value = "/createfight", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public Fight newFight(@RequestParam("blue_id") int blue_id, @RequestParam("red_id") int red_id, @RequestParam("date") String dateString) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = dateFormat.parse(dateString);
		Fight fight = new Fight(blue_id, red_id, date);
		return fightService.createFight(fight);
	}
	@RequestMapping(value = "/removefighter", method = RequestMethod.DELETE, consumes = {"multipart/form-data"})
	public Boolean removeFighter(@RequestParam("id") Long id) {
		return fighterService.removeFighter(id);
	}
	@RequestMapping(value = "/removefight", method = RequestMethod.DELETE, consumes = {"multipart/form-data"})
	public Boolean removeFight(@RequestParam("id") Long id) {
		return fightService.removeFight(id);
	}
}
