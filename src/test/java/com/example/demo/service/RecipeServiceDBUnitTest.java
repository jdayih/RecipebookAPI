package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.domain.Recipe;
import com.example.demo.repo.RecipeRepo;

@SpringBootTest
@ActiveProfiles("Test")
public class RecipeServiceDBUnitTest {

	@Autowired
	private RecipeServiceDB service;

	@MockBean
	private RecipeRepo repo;

	@Test
	void testDelete() {
		Recipe newRecipe = new Recipe("Spaghetti", 380, 45, 4);
		Recipe savedRecipe = new Recipe(1L, "Spaghetti", 380, 45, 4);
		Mockito.when(this.repo.existsById(savedRecipe.getId())).thenReturn(false);
		assertThat(this.service.removeRecipe(savedRecipe.getId())).isTrue();
		Mockito.verify(this.repo, Mockito.times(1)).existsById(savedRecipe.getId());
	}

	@Test
	void testRead() {
		Recipe newRecipe = new Recipe("Spaghetti", 380, 45, 4);
		Recipe savedRecipe = new Recipe(1L, "Spaghetti", 380, 45, 4);
		List<Recipe> recipes = List.of(savedRecipe);
		Mockito.when(this.repo.findAll()).thenReturn(recipes);
		assertThat(this.service.getRecipes()).isEqualTo(recipes);
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	void testGetById() {
		Recipe newRecipe = new Recipe("Spaghetti", 380, 45, 4);
		Recipe savedRecipe = new Recipe(1L, "Spaghetti", 380, 45, 4);
		Mockito.when(this.repo.findById(savedRecipe.getId())).thenReturn(Optional.of(savedRecipe));
		assertThat(this.service.getRecipeById(savedRecipe.getId())).isEqualTo(savedRecipe);
		Mockito.verify(this.repo, Mockito.times(1)).findById(savedRecipe.getId());
	}

	@Test
	void testCreate() {
		Recipe newRecipe = new Recipe("Spaghetti", 380, 45, 4);
		Recipe savedRecipe = new Recipe(1L, "Spaghetti", 380, 45, 4);
		Mockito.when(this.repo.save(newRecipe)).thenReturn(savedRecipe);
		assertThat(this.service.createRecipe(newRecipe)).isEqualTo(savedRecipe);
		Mockito.verify(this.repo, Mockito.times(1)).save(newRecipe);
	}

	@Test
	void testUpdate() {
		Long id = 1L;
		Recipe newRecipe = new Recipe("Cheeseburger", 580, 45, 1);
		Optional<Recipe> optionalRecipe = Optional.of(new Recipe(id, null, 0, 0, 0));
		Recipe updatedRecipe = new Recipe(id, newRecipe.getName(), newRecipe.getCalories(), newRecipe.getPrepTime(),
				newRecipe.getServingSize());
		Mockito.when(this.repo.findById(id)).thenReturn(optionalRecipe);
		Mockito.when(this.repo.save(updatedRecipe)).thenReturn(updatedRecipe);
		assertThat(this.service.updateRecipe(id, newRecipe)).isEqualTo(updatedRecipe);
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(updatedRecipe);
	}

}
