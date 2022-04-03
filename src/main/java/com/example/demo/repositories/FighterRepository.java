package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Fighter;
@Repository
public interface FighterRepository extends JpaRepository<Fighter, Long>{

}
