<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script> 

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 추가하기</h1>
		<div class="form-group">
			<label for="name">제목</label>
			<input type="text" id="name" class="form-control">
		</div>
		<div class="form-group">
			<label for="url">주소</label>
			<div class="form-inline">
				<input type="text" id="url" class="form-control col-11">
				<button type="button" id="checkDuplicationBtn" class="btn btn-info">중복확인</button>
			</div>
			<small id="duplicationText" class="text-danger d-none">중복된 url 입니다.</small>
			<small id="availableUrlText" class="text-success d-none">저장 가능한 url 입니다.</small>
		</div>
		<button type="button" id="addFavoriteBtn" class="btn btn-success btn-block">추가</button>
	</div>
<script>
$(document).ready(function() {
	
	// button에 id 생성 후
	// button을 눌렀을 때 이벤트 생성
	$('#addFavoriteBtn').on('click', function(e) {
		// alert("추가 버튼 클릭");
		
		// validation
		let name = $("#name").val().trim(); // trim => 여백제거
		
		if (name == '') { // name.length < 1
			alert("제목을 입력해주세요");
			return;
		}
		// 이벤트 생성하지도 않고 if문 만든 내가 레전드,,, 이제라도 알았으니 조심하자
	
		let url = $("#url").val().trim();
		
		if (url == '') {
			alert("주소를 입력하세요");
			return;
		}
		
		// http만 입력했을 땐 왜 확인하라할까? ||이 아닌 &&이다...
		if (url.startsWith("http://") == false && url.startsWith("https://") == false) {
			alert("주소 형식이 잘못되었습니다");
			return;
		}
		
		$.ajax({
			// request => type, url, data 받고 넘기기
			type: "post"
			, url: "/lesson06/quiz01/add_favorite_view" // _view 화면 없으면 데이터
			, data: {"name":name, "url":url} // json request파라미터 타입과 값?
			
			// response => 성공 여부
			, success: function(data) {		// url에서 리턴된 json String을 object로 변환해준다.(jquery ajax함수가)
				// 서버를 먼저 구현하고 오기!!!
				/* alert(data.result); // dictionary의 key의 value?
				location.href = "/lesson06/quiz01/favorite_list_view"; */
				if (data.result == "success") {
					location.href = "/lesson06/quiz01/favorite_list_view";
				}
			}
			, error: function(e) {
				alert("에러" + e); // [Object object]
			}
		});
	});
	
	// quiz02) 중복확인
	$('#checkDuplicationBtn').on('click', function() {
		// alert("클릭");
		let url = $('#url').val().trim();
		if (url == '') {
			alert("검사할 URL을 입력해주세요.");
			return;
		}
		
		$.ajax({
			type:"post"
			, url: "/lesson06/quiz02/check_duplication_url"
			, data: {"url":url}
			, success: function(data) {
				if (data.result) { // == (data.result == true)
					// 중복일 때
					$('#duplicationText').removeClass('d-none');
					$('#availableUrlText').addClass('d-none');
				} else {
					// 중복이 아닐 때 => 사용 가능 url
					$('#availableUrlText').removeClass('d-none');
					$('#duplicationText').addClass('d-none');
				}
				
			}
			, error: function(e) {
				alert("중복확인에 실패했습니다. 관리자에게 문의해주세요.");
			}
		});
	});
});
</script>
</body>
</html>