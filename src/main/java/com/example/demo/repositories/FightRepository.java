package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Fight;
@Repository
public interface FightRepository extends JpaRepository<Fight, Long>{

}
