package com.quiz.lesson05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson05.bo.WeatherHistoryBO;
import com.quiz.lesson05.model.WeatherHistory;

@RequestMapping("/lesson05")
@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	// 요청 URL : http://localhost/lesson05/weather_history
	@RequestMapping("/weather_history")
	public String weatherHistory(Model model) {
		// select DB
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		
		// add model
		model.addAttribute("weatherHistoryList", weatherHistoryList);

		return "lesson05/weather_history";
	}
	
	// 요청 URL : http://localhost/lesson05/add_weather_view
	@RequestMapping("/add_weather_view")
	public String addWeatherView() {
		return "lesson05/add_weather_history";
	}
	
	// 요청 URL : http://localhost/lesson05/add_weather
	@PostMapping("/add_weather")
	public String addWeather(
			@RequestParam("date") String date,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed
	) {
		// TODO add data (db insert)
		weatherHistoryBO.addWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		// redirect => 날씨 정보 리스트 화면
		return "redirect:/lesson05/weather_history";
	}
}
