package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Recipe;

public class RecipeServiceList implements RecipeService {

	private List<Recipe> recipes;

	public RecipeServiceList(List<Recipe> recipes) {
		super();
		this.recipes = recipes;
	}

	@Override
	public Recipe createRecipe(Recipe recipe) {
		this.recipes.add(recipe);
		Recipe added = this.recipes.get(this.recipes.size() - 1);
		return added;
	}

	@Override
	public List<Recipe> getRecipes() {
		return this.recipes;
	}

	@Override
	public Recipe getRecipeById(int id) {
		return this.recipes.get(id);
	}

	@Override
	public void removeRecipe(int id) {
		this.recipes.remove(id);
	}

}
