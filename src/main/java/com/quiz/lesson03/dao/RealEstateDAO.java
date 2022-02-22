package com.quiz.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.model.RealEstate;

@Repository
public interface RealEstateDAO {

	// SELECT
	public RealEstate selectRealEstateById(int id);

	public List<RealEstate> selectRealEstateListByRentPrice(int rentPrice);

	public List<RealEstate> selectRealEstateListByAreaAndPrice(
			// 파라미터가 두개 이상인 경우
			@Param("area") int area,
			@Param("price") int price); // @Param은 파라미터들을 map으로 구성해준다.
	
	// INSERT
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstateAsField(
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") int rentPrice);
	
	public RealEstate selectRealEstateRealtorId(int realtorId);
}
