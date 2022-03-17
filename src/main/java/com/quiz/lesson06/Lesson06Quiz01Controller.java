package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.FavoriteBO;
import com.quiz.lesson06.model.Favorite;

@Controller
public class Lesson06Quiz01Controller {

	@Autowired
	private FavoriteBO favoriteBO;
	
	// 즐겨찾기 추가하는 화면
	// 요청 URL : http://localhost/lesson06/quiz01/add_favorite_view
	@RequestMapping("/lesson06/quiz01/add_favorite_view")
	public String addFavoriteView() {
		return "lesson06/add_favorite";
	}
	
	
	// 즐겨찾기 추가 수행 - AJAX가 요청하는 API
	// 요청 URL : http://localhost/lesson06/quiz01/add_favorite
	@ResponseBody
	@PostMapping("/lesson06/quiz01/add_favorite")
	public Map<String, String> addFavorite( // json으로 결과값을 내려줌
			@RequestParam("name") String name,
			@RequestParam("url") String url
	) {
		// insert db
		favoriteBO.addFavorite(name, url);
		
		// 응답값 구성(map -> json string)
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		
		// return 응답값
		return result;
	}
	
	// 요청 URL : http://localhost/lesson06/quiz01/favorite_list_view
	@RequestMapping("/lesson06/quiz01/favorite_list_view")
	public String favoriteListView(Model model) { // 그냥 화면이기 때문에 모델이 가능하다
		// db select
		List<Favorite> favoriteList = favoriteBO.getFavoriteList();
		
		// model에 담는다
		model.addAttribute("favoriteList", favoriteList);
		
		return "lesson06/favorite_list";
	}
}
