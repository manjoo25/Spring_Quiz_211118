package com.quiz.lesson05.dao;

import org.springframework.stereotype.Repository;

import com.quiz.lesson05.model.Weather;

@Repository
public interface WeatherDAO {

	public Weather selectWeather();
}
