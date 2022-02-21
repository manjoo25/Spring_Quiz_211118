package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.dao.StoreDAO;
import com.quiz.lesson02.model.Store;

@Service
public class StoreBO {

	// 비즈니스 오브젝트 -> BO
	
	@Autowired
	private StoreDAO storeDAO; // 스프링 
	
	public List<Store> getStoreList() { // 여러개의 행을 호출하는 메소드
		
		List<Store> storeList = storeDAO.selectStoreList(); // 가공없이 controller한테 넘겨준다
		return storeList;
	}
}
