package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.dao.StoreDAO;
import com.quiz.lesson02.model.Store;

@Service
public class StoreBO {

	@Autowired
	private StoreDAO storeDAO;		// (2) BO가 DAO를 호출..?
	
	public List<Store> getStoreList() {
		
		return storeDAO.selectStoreList(); // (4) DAO가 받은 DB데이터를 BO에서 리턴(반환받는다)
		
		// service가 데이터를 이용해서 로직을 수행한다에서 로직을 수행시킨다는게 어떤 뜻이죵,,?
	}
}
