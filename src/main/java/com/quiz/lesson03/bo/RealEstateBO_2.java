package com.quiz.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.dao.RealEstateDAO_2;
import com.quiz.lesson03.model.RealEstate;

@Service
public class RealEstateBO_2 {

	@Autowired
	private RealEstateDAO_2 realEstateDAO;
	
	public RealEstate getRealEstate(int area, int price) {
		return realEstateDAO.selectRealEstate(area, price);
	}
}
