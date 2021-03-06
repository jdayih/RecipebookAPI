package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Recipe;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Long> {

	Recipe findByName(String name);
}