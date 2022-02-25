package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.dao.SellerDAO;
import com.quiz.lesson04.model.Seller;

@Service
public class SellerBO { // 테이블명 + BO

	@Autowired
	private SellerDAO sellerDAO;
	
	public void addSeller(String nickname, String profileImageUrl, double temperature) { // 파라미터 따로따로 보내는 형식
		sellerDAO.insertSeller(nickname, profileImageUrl, temperature);
	}
	
	public Seller getLastSeller() { // Seller 클래스에서 데이터들을 갖고 온다
		return sellerDAO.selectLastSeller();
	}
	
	public Seller getSellerById(int id) {
		return sellerDAO.selectSellerById(id);
	}
}
