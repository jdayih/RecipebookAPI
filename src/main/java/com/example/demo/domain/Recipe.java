package com.example.demo.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;

	private String name;
	private int calories;
	private int prepTime;
	private int servingSize;

	public Recipe() {
	}

	public Recipe(long id, String name, int calories, int prepTime, int servingSize) {
		super();
		this.id = id;
		this.name = name;
		this.calories = calories;
		this.prepTime = prepTime;
		this.servingSize = servingSize;
	}

	public Recipe(String name, int calories, int prepTime, int servingSize) {
		super();
		this.name = name;
		this.calories = calories;
		this.prepTime = prepTime;
		this.servingSize = servingSize;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}

	public int getServingSize() {
		return servingSize;
	}

	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}
}
