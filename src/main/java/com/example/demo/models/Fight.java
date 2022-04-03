package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fights")
public class Fight {
	@Id
	public int id;
	@Column(name = "blue_fighter")
	public int blue_fighter;
	@Column(name = "red_fighter")
	public int red_fighter;
	@Column(name = "_date")
	public Date date;
	public Fight(int id, int blue, int red, Date date) {
		this.id = id;
		this.blue_fighter = blue;
		this.red_fighter = red;
		this.date = date;
	}
}
