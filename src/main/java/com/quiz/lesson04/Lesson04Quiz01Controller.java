package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.model.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {

	@Autowired
	private SellerBO sellerBO;
	
	// 판매자 추가
	// 입력 form URL : http://localhost/lesson04/quiz01/1
	// @RequestMapping(path="/1", method=RequestMethod.GET)
	// @GetMapping("/1")
	@RequestMapping("/1")
	
	// 판매자 추가 add_seller.jsp
	public String quiz01_1() {
		return "lesson04/add_seller";
	}
	
	// submit
	// 입력 action URL : http://localhost/lesson04/quiz01/add_seller
	@PostMapping("/add_seller") // 어떤 메소드를 허용할 것인지
	
	// 위에서 입력받은 값을 잘 받았는지 확인하는 view // after_add_seller.jsp
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value="profileImageUrl", required=false) String profileImageUrl,
			@RequestParam("temperature") double temperature
	) {
		// DB insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// response: view 경로
		return "lesson04/after_add_seller"; // break point
	}
	
	// 요청 URL : http://localhost/lesson04/quiz01/seller_info
	// 요청 URL : http://localhost/lesson04/quiz01/seller_info?id=8
	// @GetMapping("/seller_info")
	@RequestMapping("/seller_info")
	
	public String sellerInfo(
			@RequestParam(value="id", required=false) Integer id, // 비필수 파라미터 허용 => int(x) Integer(o)
			Model model
	) {
		Seller seller = null;
		if (id == null) {
			seller = sellerBO.getLastSeller();
		} else {
			// id != null => id에 값이 들어가는 경우
			seller = sellerBO.getSellerById(id);
		}
		
		model.addAttribute("seller", seller); // 테이블 이름을 result로 대체? ("키", value)
		model.addAttribute("subject", "판매자 정보");
		return "lesson04/seller_info";
	}
}