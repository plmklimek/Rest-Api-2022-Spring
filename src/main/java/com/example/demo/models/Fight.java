package com.example.demo.models;

import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "fights")
public class Fight {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	@Column(name = "blue_fighter")
	public int blue_fighter;
	@Column(name = "red_fighter")
	public int red_fighter;
	@Column(name = "_date")
	public Date date;
	@Transient
	public Fighter fighter;
	public Fight() {
		super();
	}
	public Fight(int blue_id, int red_id, Date date) {
		this.blue_fighter = blue_id;
		this.red_fighter = red_id;
		this.date = date;
	}
	public Fight(Long id, int blue, int red, Date date) {
		this.id = id;
		this.blue_fighter = blue;
		this.red_fighter = red;
		this.date = date;
	}
}
