package com.example.demo.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.demo.domain.Recipe;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:recipe-schema.sql",
		"classpath:recipe-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class RecipeControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Recipe newRecipe = new Recipe("Tomato Soup", 150, 45, 4);
		String newRecipeAsJSON = this.mapper.writeValueAsString(newRecipe);
		RequestBuilder mockRequest = post("/createRecipe").contentType(MediaType.APPLICATION_JSON)
				.content(newRecipeAsJSON);
		Recipe savedRecipe = new Recipe(2L, "Tomato Soup", 150, 45, 4);
		String savedRecipeAsJSON = this.mapper.writeValueAsString(savedRecipe);
		ResultMatcher matchStatus = status().isCreated();
		ResultMatcher matchBody = content().json(savedRecipeAsJSON);
		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
	}

	@Test
	void readTest() throws Exception {
		Recipe testRecipe = new Recipe(1L, "Tomato Soup", 150, 45, 4);
		List<Recipe> allRecipes = List.of(testRecipe);
		String testRecipeAsJSON = this.mapper.writeValueAsString(allRecipes);
		RequestBuilder mockRequest = get("/getRecipes");
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testRecipeAsJSON);
		this.mockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void updateTest() throws Exception {
		Recipe testRecipe = new Recipe("Tomato Soup", 150, 45, 4);
		String testRecipeAsJSON = this.mapper.writeValueAsString(testRecipe);
		RequestBuilder mockRequest = put("/updateRecipe/1").contentType(MediaType.APPLICATION_JSON)
				.content(testRecipeAsJSON);
		Recipe updateRecipe = new Recipe(1L, "Tomato Soup", 150, 45, 4);
		String updateRecipeAsJSON = this.mapper.writeValueAsString(updateRecipe);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(updateRecipeAsJSON);
		this.mockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void deleteTest() throws Exception {
		RequestBuilder mockRequest = delete("/removeRecipe/1");
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().string("true");
		this.mockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
	}

}
