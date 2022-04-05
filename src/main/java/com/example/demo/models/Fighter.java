package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fighters")
public class Fighter {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	@Column(name = "name")
	public String name;
	@Column(name = "surname")
	public String surname;
	@Column(name = "age")
	public int age;
	public Fighter(Long id, String name, String surname, int age) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	public Fighter() {
		// TODO Auto-generated constructor stub
	}
}
