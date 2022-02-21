package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.model.RealEstate;

@RestController
@RequestMapping("/lesson03/quiz01")
public class Lesson03Quiz01RestController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	// 요청 URL : http://localhost/lesson03/quiz01/1?id=20
	@RequestMapping("/1")
	public RealEstate quiz01_1(
			@RequestParam(value="id", defaultValue="20") int id
	){
		return realEstateBO.getRealEstate(id);
	}
	
	// 요청 URL : http://localhost/lesson03/quiz01/2?rent_price=90
	@RequestMapping("/2")
	public RealEstate quiz01_2(
			@RequestParam(value="rent_price", defaultValue="90") Integer rent_price
	){
		return realEstateBO.getRealEstate(rent_price);
	}
	
	// 요청 URL : http://localhost/lesson03/quiz01/3?area=90&price=130000
	@RequestMapping("/3")
	public RealEstate quiz01_3(
			@RequestParam(value="area", defaultValue="90") int area,
			@RequestParam(value="price", defaultValue="130000") int price
	){
		return realEstateBO.getRealEstate(price);
	}
}
