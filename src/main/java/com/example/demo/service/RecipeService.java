package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Recipe;

public interface RecipeService {

	Recipe createChicken(Recipe chicken);

	List<Recipe> getRecipes();

	Recipe getRecipeById(Long id);

	boolean removeRecipe(Long id);

	Recipe updateRecipe(Long id, Recipe newRecipe);

	Recipe getRecipeByName(String name);

}
