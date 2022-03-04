<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제5</title>
	<!-- bootstrap CDN link -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<style>
	
</style>
<body>
	<div class="container">
		<section>
			<div class="d-flex">
				<div class="bg-info w-25">
					<div class="d-flex justify-content-center align-items-center">
						<img src="/src/main/resources/static/image/logo.jpg">기상청
					</div>
					<ul class="nav flex-column">
						<li class="nav-item"><a href="#" class="nav-link">날씨</a></li>
						<li class="nav-item"><a href="#" class="nav-link">날씨입력</a></li>
						<li class="nav-item"><a href="#" class="nav-link">테마날씨</a></li>
						<li class="nav-item"><a href="#" class="nav-link">관측 기후</a></li>
					</ul>
				</div>
				<section class="bg-secondary w-75">
					<h1>과거 날씨</h1>
					<table class="table text-center">
						<thead>
							<tr>
								<th>날짜</th>
								<th>날씨</th>
								<th>기온</th>
								<th>강수량</th>
								<th>미세먼지</th>
								<th>풍속</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${weather}" var="weather" varStatus="status">
							<tr>
								<td>${weather.date}</td>
								<td>${weather.weather}</td>
								<td>${weather.temperatures}</td>
								<td>${weather.precipitation}</td>
								<td>${weather.microDust}</td>
								<td>${weather.windSpeed}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</section>
			</div>
		</section>
		<footer>
			<div class="d-flex justify-content-center align-items-center">
				<img alt="footer_logo" src="src\main\resources\static\image\f_logo.jpg" class="w-25">
				<div class="w-75">
					<small>(07062)서울특별시 동작구 여의대방로16길 61<br>
					Copyright@2022 KMA. All Rights RESERVED.</small>
				</div>
			</div>
		</footer>
	</div>
</body>
</html>