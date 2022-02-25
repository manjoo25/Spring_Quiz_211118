package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.model.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {
	
	@Autowired
	private RealtorBO realtorBO; 

	// 입력 form URL : http://localhost/lesson04/quiz02/1
	@RequestMapping("/1")
	
	public String quiz02_1() {
		return "lesson04/add_realtor";
	}
	
	// 입력 action URL : http://localhost/lesson04/quiz02/add_realtor
	@PostMapping("/add_realtor")
	
	public String addRealtor(
			@ModelAttribute Realtor realtor, // 괄호 아님!!!!
			Model model
	) {
		// db insert
		realtorBO.addRealtor(realtor);
		
		// db select?...? ->>>>>>>>> model 객체에 담는다! ((방금 인서트 된 데이터를 DB SELECT))
		realtor = realtorBO.getRealtorById(realtor.getId());
		model.addAttribute("subject", "공인중개사 정보");
		model.addAttribute("realtor", realtor);
		
		// 공인중개사 추가
		return "lesson04/after_add_realtor";
	}
}
