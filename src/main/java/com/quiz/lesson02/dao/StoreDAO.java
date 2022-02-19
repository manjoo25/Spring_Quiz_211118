package com.quiz.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson02.model.Store;

@Repository
public interface StoreDAO {
	//다른 클래스를 작성할 때 기본이 되는 틀을 제공하면서, 다른 클래스 사이의 중간 매개 역할까지 담당하는 일종의 추상 클래스를 의미합니다.

	public List<Store> selectStoreList(); // (3) 데이터 조회?
}
