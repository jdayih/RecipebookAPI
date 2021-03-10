package com.example.demo.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Recipe;
import com.example.demo.service.RecipeService;

@RestController
public class RecipeController {

	private RecipeService service;

	public RecipeController(RecipeService service) {
		super();
		this.service = service;
	}

	@PostMapping("/createRecipe")
	public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
		return new ResponseEntity<Recipe>(this.service.createRecipe(recipe), HttpStatus.CREATED);
	}

	@GetMapping("/getRecipes")
	public ResponseEntity<List<Recipe>> getRecipes() {
		return ResponseEntity.ok(this.service.getRecipes());
	}

	@GetMapping("/getRecipeById/{id}")
	public Recipe getPenguinById(@PathVariable int id) {
		return this.service.getRecipeById(id);
	}

	@DeleteMapping("/removeRecipe/{id}")
	public void removePenguin(@PathVariable int id) {
		this.service.removeRecipe(id);
	}

}
