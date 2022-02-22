package com.quiz.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.dao.RealEstateDAO;
import com.quiz.lesson03.model.RealEstate;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateDAO realEstateDAO;
	
	public RealEstate getRealEstate(int id) {
		return realEstateDAO.selectRealEstate(id);
	}
	
	/*
	 * @Autowired private RealEstateDAO realEstateDAO1;
	 */

	public RealEstate getRealEstate(Integer rent_price) {
		return realEstateDAO.selectRealEstate(rent_price);
	}
	
	/*
	 * @Autowired private RealEstateDAO realEstateDAO2;
	 */
	
	public RealEstate getRealEstate(int area, int price) {
		return realEstateDAO.selectRealEstate(area, price);
	}
}
