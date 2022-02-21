package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.model.Store;

@RestController // 데이터를 내려주는 것이기 때문에 ResponseBody가 필요하다!!!
// 데이터를 응답값(Response)으로 내린다.
// request를 받는다
public class Lesson02Quiz01RestController {
	
	@Autowired
	private StoreBO storeBO;
	// BO가 필요할 때마다 각각의 스프링 빈위에다가 @Autowired해줘야된다
	
	// Controller는 기본적으로 Model에 대한 처리(DB로 부터 적정 정보 획득)와 이후 이동할 페이지 정보(View 정보)를
	// return 하는 역할이 Controller가 하는 역할이다.
	
	// 요청 URL : http://localhost/lesson02/quiz01
	@RequestMapping("/lesson02/quiz01")
	public List<Store> quiz01() { // [] -> List 형태, Store => class (model 패키지에 있는걸로!!), quiz01() => 메소드
		List<Store> storeList = storeBO.getStoreList();
		return storeList;
	}
}
