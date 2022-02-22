package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.dao.RealEstateDAO;
import com.quiz.lesson03.model.RealEstate;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateDAO realEstateDAO;
	
	// SELECT
	public RealEstate getRealEstatById(int id) {
		return realEstateDAO.selectRealEstateById(id);
	}

	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
		return realEstateDAO.selectRealEstateListByRentPrice(rentPrice);
	}
	
	public List<RealEstate> getRealEstateListByAreaAndPrice(int area, int price) {
		return realEstateDAO.selectRealEstateListByAreaAndPrice(area, price);
	}
	
	// INSERT
	public int addRealEstate(RealEstate realEstate) {
		return realEstateDAO.insertRealEstate(realEstate);
	}

	public int addRealEstateAsField(String address, int area, String type, int price, int rentPrice) {
		return realEstateDAO.insertRealEstateAsField(address, area, type, price, rentPrice);
	}
}