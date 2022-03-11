package com.quiz.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.FavoriteBO;
import com.quiz.lesson06.model.Favorite;

@Controller
public class Lesson06Quiz02Controller {

	@Autowired
	private FavoriteBO favoriteBO;
	
	// 요청 URL : http://localhost/lesson06/quiz02/add_url
	@RequestMapping("/lesson06/quiz02/add_url")
	
	public String addUrl() {
		return "lesson06/add_url";
	}
	
	// 주소의 중복확인 - AJAX를 통해 오는 요청
	@ResponseBody // json은 String으로 내려간다
	@PostMapping("/lesson06/quiz02/check_duplication_url")
	public Map<String, Boolean> checkDuplicationUrl(
			@RequestParam("url") String url) {
		Map<String, Boolean> result = new HashMap<>();
		Favorite favorite = favoriteBO.getFavoriteByUrl(url);
		result.put("result", false);
		
		if (favorite != null) {
			// 중복
			result.put("result", true);
		}
		
		return result;
	}
	
	// AJAX 요청
	// 요청 URL : http://localhost/lesson06/quiz02/delete_favorite
	@ResponseBody
	@PostMapping("/lesson06/quiz02/delete_favorite")
	public Map<String, String> deleteFavorite(
			@RequestParam("id") int id) {
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		
		int row = favoriteBO.deleteFavoriteById(id);
		if (row > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "error");
			result.put("errorMessage", "삭제하는데 실패했습니다");
		}
		
		return result;
	}
}