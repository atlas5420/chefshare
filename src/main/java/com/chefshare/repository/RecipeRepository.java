package com.chefshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chefshare.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

}
