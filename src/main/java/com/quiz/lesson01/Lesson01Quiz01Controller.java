package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 안쓰면 404 오류 생김!!!! @RequestMapping @Controller @ResponseBody 세트로 기억하고 제일먼저 어노테이션 할 것!!!

@RequestMapping("/lesson01/quiz01")
@Controller
public class Lesson01Quiz01Controller {

	// 요청 URL : http://localhost:8080/lesson01/quiz01/1
	@RequestMapping("/1")
	@ResponseBody
	public String quiz01_1() { // 바로 return 값에 넣어줘도 됨
		// return = "<h1>테스트 프로젝트 완성</h1><h3>해당 프로젝트를 통해서 문제 풀이를 진행 합니다.</h3>";
		String text01 ="<h1>테스트 프로젝트 완성</h1><b>해당 프로젝트를 통해서 문제 풀이를 진행 합니다.</b>";
		return text01;
	}
	
	// 요청 URL : http://localhost:8080/lesson01/quiz01/2
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Object> quiz01_2() { // Map<String, Integer> 로 해도 됨
		Map<String, Object> map = new HashMap<>();
		map.put("국어", 80);
		map.put("수학", 90);
		map.put("영어", 85);
		
		return map;
	}
}
