package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.model.Store;

@RestController
public class Lesson02Quiz01RestController {
	
	@Autowired
	private StoreBO storeBO;

	// Controller는 기본적으로 Model에 대한 처리(DB로 부터 적정 정보 획득)와 이후 이동할 페이지 정보(View 정보)를
	// return 하는 역할이 Controller가 하는 역할이다.
	
	// 요청 URL : http://localhost/lesson02/quiz01
	@RequestMapping("/lesson02/quiz01")
	public List<Store> quiz01() {
		return storeBO.getStoreList(); // (1) Store의 정보를 가져와서 BO로 넘긴다.?(반환한다?)
	}
}
