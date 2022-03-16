package com.chefshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chefshare.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

}
