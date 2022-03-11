<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section>
	<div>
		<img src="/image/banner1.jpg" id="bannerImage">
	</div>
	<div class="reservation d-flex">
	<div class="info-side d-flex justify-content-center align-items-center col-4">
		<div class="display-4">실시간<br>예약하기</div>
	</div>
		<div class="info-center col-4">
			<h4 class="m-3">예약 확인</h4>
			<div class="form-group d-flex">
				<label for="name"><span class="pl-5 m-2">이름: </span></label>
				<input type="text" id="name" class="form-control col-8">
			</div>
			<div class="form-group d-flex">
				<label for="phoneNumber"><span class="pl-3 m-2">전화번호: </span></label>
				<input type="text" id="phoneNumber" class="form-control col-8">
			</div>
			<div class="d-flex justify-content-end align-items-center">
				<botton type="botton" class="btn btn-success col-4">조회</botton>
			</div>
		</div>
		<div class="info-side d-flex justify-content-center align-items-center col-4">
			<div>
				<h4>예약문의:</h4>
				<h3>010-<br>0000-1111</h3>
			</div>
		</div>
	</div>
</section>

<script>
$(document).ready(function() {
	$()
});
var bannerSrcArr = ['/image/banner1.jpg', '/image/banner2.jpg', '/image/banner3.jpg', '/image/banner4.jpg'];
var currentIndex = 0;
setInterval(function() {
    $('#bannerImage').attr('src', bannerSrcArr[currentIndex]);
    currentIndex++;

    if (currentIndex > bannerSrcArr.length) { // 인덱스 값이 배열의 크기를 넘으면 0으로(처음 이미지) 세팅
        currentIndex = 0;
    }
}, 3000);
</script>