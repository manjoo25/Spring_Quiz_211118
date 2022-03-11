<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<section>
	<div class="d-flex justify-content-center align-items-center">
		<h2 class="font-weight-bold py-3">예약 목록 보기</h2>
	</div>
	<table class="table">
		<thead>
			<tr>
				<th>이름</th>
				<th>예약날짜</th>
				<th>숙박일수</th>
				<th>숙박인원</th>
				<th>전화번호</th>
				<th>예약상태</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${bookingList}" var="booking">
			<tr>
				<td>${booking.name}</td>
				<td><fmt:formatDate value="${booking.date}" pattern="yyyy년 M월 d일"/></td>
				<td>${booking.day}</td>
				<td>${booking.headcount}</td>
				<td>${booking.phoneNumber}</td>
				<td>
					<c:choose>
						<c:when test="${booking.state eq '확정'}">
							<span class="text-success">${booking.state}</span>
						</c:when>
						<c:when test="${booking.state eq '대기중'}">
							<span class="text-info">${booking.state}</span>
						</c:when>
						<c:when test="${booking.state eq '취소'}">
							<span class="text-danger">${booking.state}</span>
						</c:when>
						<%-- 혹시라도 새로운 경우가 생길 수 있으니
						<c:otherwise>
							<span class="text-danger">${booking.state}</span>
						</c:otherwise> --%>
					</c:choose>
				</td>
				<td>
					<button type="button" class="del-btn btn btn-danger" data-booking-id="${booking.id}">삭제</button>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</section>

<script>
	$(document).ready(function() {
		$('.del-btn').on('click', function() {
			// alert("클릭");
			let bookingId = $(this).data('booking-id'); // 클릭된 버튼 딱 하나
			// alert(bookingId);
			
			$.ajax({
				// request
				type: "DELETE"
				, url: "/lesson06/quiz03/delete_booking" // view 화면으로 내려올 수 없다. api로만!
				, data: {"id":bookingId}
				
				// response
				, success: function(data) {
					if (data.result_code == 1) {
						alert("삭제되었습니다.");
						location.reload(); // 새로고침
					} else {
						alert(data.error_message);
					}
				}
				, error: function(e) { // ajax에서 실패
					alert("삭제에 실패했습니다.");
				}
			});
		});
	});
</script>