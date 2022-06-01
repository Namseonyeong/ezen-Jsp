package com.ezen.controller.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dto.BookingVO;

public class BookingConfirmAction implements Action {
	public static final int BASE_PRICE = 200000;
	public static final int CAPACITY = 4;
	public static final int ADULT_CHARGE = 100000;
	public static final int CHILD_CHARGE = 50000;
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "booking/booking_confirm.jsp";
		BookingVO booking = new BookingVO();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		booking.setName(request.getParameter("name"));
		booking.setPhone(request.getParameter("phone"));
		
		try {
			Date checkin_date = sdf.parse(request.getParameter("checkin"));
			Date checkout_date = sdf.parse(request.getParameter("checkout"));
			booking.setCheck_in(checkin_date);
			booking.setCheck_out(checkout_date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		booking.setRoom_no(request.getParameter("room_no"));
		booking.setAdult(Integer.parseInt(request.getParameter("adult")));
		String children = request.getParameter("children");
		if (children != "") {
			booking.setChildren(Integer.parseInt(request.getParameter("children")));
		} else {
			booking.setChildren(0);
		}
		booking.setReserv_yn(request.getParameter("reserve_yn"));
		booking.setBreakfast_yn(request.getParameter("breakfast_yn"));
		
		// 객실요금 계산
		int adult = booking.getAdult();
		int kids = booking.getChildren();
		int people = adult + kids;
		int extra_fee = 0;
		if (people > CAPACITY) {
			if (adult < CAPACITY) {
				extra_fee = kids * CHILD_CHARGE;
			} else {
				extra_fee = (adult-CAPACITY) * ADULT_CHARGE +
							kids * CHILD_CHARGE;
			}
		}
		int total = BASE_PRICE + extra_fee;
		booking.setPrice(total);
		
		request.setAttribute("booking", booking);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
