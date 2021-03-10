package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Recipe;

@Service
public interface RecipeService {

	Recipe createRecipe(Recipe recipe);

	List<Recipe> getRecipes();

	Recipe getRecipeById(int id);

	void removeRecipe(int id);
}