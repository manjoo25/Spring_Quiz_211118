<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section>
	<div class="d-flex justify-content-center align-items-center">
		<h2 class="font-weight-bold py-3">예약하기</h2>
	</div>
	<div class="form-group">
		<label for="name">이름</label> <input type="text" id="name" name="name" class="form-control">
	</div>
	<div class="form-group">
		<label for="date">예약날짜</label> <input type="text" id="date" name="date" class="form-control">
	</div>
	<div class="form-group">
		<label for="day">숙박일수</label> <input type="text" id="day" name="day" class="form-control">
	</div>
	<div class="form-group">
		<label for="headcount">숙박인원</label> <input type="text" name="headcount" id="headcount" class="form-control">
	</div>
	<div class="form-group">
		<label for="phoneNumber">전화번호</label> <input type="text" name="phoneNumber" id="phoneNumber" class="form-control">
	</div>
	<botton type="botton" id="reservationBtn" class="btn btn-warning w-100">예약하기</botton>
</section>
<script>
	$(document).ready(function() {
		$('input[name=date]').datepicker({
			minDate: 0 // 오늘부터 그 뒤 선택
			, dateFormat: "yy-mm-dd"
		});
		
		$('#reservationBtn').on('click', function() {
			let name = $('input[name=name]').val().trim();
			let date = $('input[name=date]').val().trim();
			let day = $('input[name=day]').val().trim();
			let headcount = $('input[name=headcount]').val().trim();
			let phoneNumber = $('input[name=phoneNumber]').val().trim();
			
			if (name == '') {
				alert("이름을 입력하세요");
				return;
			}
			
			if (date == '') {
				alert("날짜를 입력하세요");
				return;
			}
			
			if (day == '') {
				alert("숙박일을 입력하세요");
				return;
			}
			if (isNaN(day)) { // 숫자가 아닐 때
				alert("숙박일은 숫자만 입력가능합니다.");
				return;
			}
			
			if (headcount == '') {
				alert("숙박인원을 입력하세요");
				return;
			}
			if (isNaN(headcount)) { // 숫자가 아닐 때
				alert("숙박일은 숫자만 입력가능합니다.");
				return;
			}
			
			if (phoneNumber == '') {
				alert("전화번호를 입력하세요.");
				return;
			}
			
			$.ajax({
				type: "post"
				, url: "/lesson06/quiz03/add_booking"
				, data: {"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber}
				
				, success: function(data) {
					if (data.result == 'success') {
						alert("예약 되었습니다.");
						
						// 예약 목록 페이지로 넘어가기
						location.href = "/lesson06/quiz03/booking_list_view";
					} else {
						alert(data.error_message);
					}
				}
				, error: function(e) {
					alert("예약하는데 실패했습니다. 관리자에게 문의해주세요.");
				}
			});
		});
	});
</script>