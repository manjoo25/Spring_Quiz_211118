<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 목록</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script> -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 목록</h1>
		
		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${favoriteList}" var="favorite">
				<tr>
					<td>${favorite.id}</td>
					<td>${favorite.name}</td>
					<td>${favorite.url}</td>
					<td><button type="button" class="del-btn btn btn-danger" data-favorite-id="${favorite.id}">삭제</button></td><%-- value="${favorite.id}" --%>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script>
		$(document).ready(function() {
			$('.del-btn').on('click', function() {
				// 태그 : data-favorite-id ==========> data- 뒤부터는 이름을 지어준다.(카멜케이스 x)
				// 스크립트: data("favorite-id") ====
				let id = $(this).data("favorite-id");
				// alert(id);
				
				$.ajax({
					type:"post"
					, url: "/lesson06/quiz02/delete_favorite"
					, data: {"id":id}
					, success: function(data) {
						if (data.result == 'success') {
							location.reload();
						} else {
							alert(data.errorMessage);
						}
					}
					, error: function(e) {
						alert("삭제하는데 실패했습니다. 관리자에게 문의해주세요.")
					}
				});
			});
		})
	</script>
</body>
</html>