package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookingBO;
import com.quiz.lesson06.model.Booking;

@RequestMapping("/lesson06/quiz03")
@Controller
public class BookingController {

	@Autowired
	private BookingBO bookingBO;
	
	// 예약 목록 화면
	// 요청 URL : http://localhost/lesson06/quiz03/booking_list_view
	@RequestMapping("/booking_list_view")
	public String bookingListView(Model model) {
		List<Booking> bookingList = bookingBO.getBookingList();
		model.addAttribute("bookingList", bookingList);
		
		return "lesson06/booking/list_template";
	}
	
	// 예약 삭제하기 - ajax 요청
	@ResponseBody
	@DeleteMapping("/delete_booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		
		Map<String, Object> result = new HashMap<>();
		// TODO delete DB
		int count = bookingBO.deleteBookingById(id);
		if (count > 0) {
			result.put("result", "success");
			result.put("result_code", 1);
		} else {
			result.put("result", "error");
			result.put("result_code", 500);
			result.put("error_message", "삭제가 실패했습니다."); // 서버에서 실패
		}
		
		return result;
	}
	
	// 예약하기 화면
	// 요청 URL : http://localhost/lesson06/quiz03/booking_add_view
	@RequestMapping("/booking_add_view")
	public String bookingAddView() {
		return "lesson06/booking/add_template";
	}
	
	// 예약하기 - ajax 호출
	@ResponseBody
	@PostMapping("/add_booking")
	public Map<String, Object> addBooking(
			@RequestParam("name") String name,
			@RequestParam("date") String date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber
	) {
		Map<String, Object> result = new HashMap<>();
		// DB insert
		int count = bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		if (count > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "error");
			result.put("error_message", "예약에 실패했습니다.");
		}
		
		return result;
	}
	
	// 요청 URL : http://localhost/lesson06/quiz03/booking_info_view
	@RequestMapping("/booking_info_view")
	public String bookingInfoView() {
		return "lesson06/booking/info_template";
	}
	
	
}
