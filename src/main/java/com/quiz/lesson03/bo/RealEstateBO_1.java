package com.quiz.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.dao.RealEstateDAO_1;
import com.quiz.lesson03.model.RealEstate;

@Service
public class RealEstateBO_1 {

	@Autowired
	private RealEstateDAO_1 realEstateDAO;

	public RealEstate getRealEstate(Integer rent_price) {
		return realEstateDAO.selectRealEstate(rent_price);
	}
}
