package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.domain.Recipe;

public class RecipeController {

	private List<Recipe> recipes = new ArrayList<>();

	@PostMapping("/createRecipe")
	public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
		this.recipes.add(recipe);
		Recipe added = this.recipes.get(this.recipes.size() - 1);
		return new ResponseEntity<Recipe>(added, HttpStatus.CREATED);
	}

	@GetMapping("/getRecipes")
	public ResponseEntity<List<Recipe>> getRecipes() {
		return ResponseEntity.ok(this.recipes);
	}

	@GetMapping("/getRecipeById/{id}")
	public Recipe getRecipeById(@PathVariable int id) {
		return this.recipes.get(id);
	}

	@DeleteMapping("/removeRecipe/{id}")
	public Recipe removeRecipe(@PathVariable int id) {
		return this.recipes.remove(id);
	}

}
