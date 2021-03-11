package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calories;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + prepTime;
		result = prime * result + servingSize;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		if (calories != other.calories)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (prepTime != other.prepTime)
			return false;
		if (servingSize != other.servingSize)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", calories=" + calories + ", prepTime=" + prepTime
				+ ", servingSize=" + servingSize + "]";
	}

}
