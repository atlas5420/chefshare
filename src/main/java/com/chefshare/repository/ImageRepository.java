package com.chefshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chefshare.model.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

}
