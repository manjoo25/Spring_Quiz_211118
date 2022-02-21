package com.quiz.lesson03.dao;

import org.springframework.stereotype.Repository;

import com.quiz.lesson03.model.RealEstate;

@Repository
public interface RealEstateDAO_2 {
	
	public RealEstate selectRealEstate(int area, int price);
}
