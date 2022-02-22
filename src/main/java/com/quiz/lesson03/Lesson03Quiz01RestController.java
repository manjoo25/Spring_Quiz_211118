package com.quiz.lesson03;

import java.util.List;

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
			@RequestParam("id") int id
			// 필수 파라미터(무조건 들어가야하므로 int)
			// required가 없고 value만 들어가고 필수 값으로 들어가는 경우 value를 생략해도 됨(파라미터가 value 하나인 경우)
	){
		return realEstateBO.getRealEstatById(id);
	}
	
	// 요청 URL : http://localhost/lesson03/quiz01/2?rent_price=90
	// ret_price가 있어야 비교를 하고 값을 꺼내기 때문에 필수 없이어야 한다
	@RequestMapping("/2")
	public List<RealEstate> quiz01_2( // 결과값이 []거나 여러 개일 경우 List 형태로!!!!!!
			@RequestParam("rent_price") int rentPrice
	){
		return realEstateBO.getRealEstateListByRentPrice(rentPrice);
	}
	
	// 요청 URL : http://localhost/lesson03/quiz01/3?area=90&price=130000
	
	@RequestMapping("/3")
	public List<RealEstate> quiz01_3(
			@RequestParam("area") int area,
			@RequestParam("price") int price 
	){
		return realEstateBO.getRealEstateListByAreaAndPrice(area, price);
	}

}
