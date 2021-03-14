package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Recipe;
import com.example.demo.repo.RecipeRepo;

@Service
public class RecipeServiceDB implements RecipeService {

	private RecipeRepo repo;

	public RecipeServiceDB(RecipeRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Recipe createRecipe(Recipe recipe) {
		Recipe saved = this.repo.save(recipe);
		return saved;
	}

	@Override
	public List<Recipe> getRecipes() {
		return this.repo.findAll();
	}

	@Override
	public Recipe getRecipeById(Long id) {
		Optional<Recipe> optRecipe = this.repo.findById(id);
		return optRecipe.get();
	}

	@Override
	public boolean removeRecipe(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	@Override
	public Recipe updateRecipe(Long id, Recipe newRecipe) {
		Optional<Recipe> optionalRecipe = this.repo.findById(id);
		Recipe existing = optionalRecipe.get();
		existing.setName(newRecipe.getName());
		existing.setCalories(newRecipe.getCalories());
		existing.setPrepTime(newRecipe.getPrepTime());
		existing.setServingSize(newRecipe.getServingSize());
		Recipe updated = this.repo.save(existing);
		return updated;
	}

}