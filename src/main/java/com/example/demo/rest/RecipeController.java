package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Recipe;
import com.example.demo.service.RecipeService;

@RestController
public class RecipeController {

	private List<Recipe> recipes = new ArrayList<>();

	private RecipeService service;

	public RecipeController(RecipeService service) {
		super();
		this.service = service;
	}

	@PostMapping("/createRecipe")
	public ResponseEntity<Recipe> createPenguin(@RequestBody Recipe recipe) {
		this.recipes.add(recipe);
		Recipe added = this.recipes.get(this.recipes.size() - 1);
		return new ResponseEntity<Recipe>(added, HttpStatus.CREATED);
	}

	@GetMapping("/getRecipes")
	public ResponseEntity<List<Recipe>> getRecipe() {
		return ResponseEntity.ok(this.service.getRecipes());
	}

	@GetMapping("/getRecipeById/{id}")
	public Recipe getRecipeById(@PathVariable long id) {
		return this.service.getRecipeById(id);
	}

	@DeleteMapping("/removeRecipe/{id}")
	public boolean removeRecipe(@PathVariable long id) {
		return this.service.removeRecipe(id);
	}

	@PutMapping("/updateRecipe/{id")
	public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe newRecipe) {
		return this.service.updateRecipe(id, newRecipe);
	}

}