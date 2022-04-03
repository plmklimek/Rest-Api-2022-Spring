package com.example.demo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Fighter;
import com.example.demo.repositories.FighterRepository;
import com.example.demo.services.FighterService;

@RestController
public class HelloWorld {

	final FighterService fighterService;
	public HelloWorld(FighterService fighterService){
		this.fighterService = fighterService;
	}
	@GetMapping(path="/getname")
	public  List<Fighter> getHello() throws SQLException {
		return fighterService.getAll();
		
	}

}
