package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Recipe;

public interface RecipeService {

	Recipe createRecipe(Recipe recipe);

	List<Recipe> getRecipes();

	Recipe getRecipeById(Long id);

	boolean removeRecipe(Long id);
}