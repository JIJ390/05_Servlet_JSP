package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 주소 적는 거 확인!!!!
@WebServlet("/chicken")
public class ChickenServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpServletRequest : 요청자 정보, 전달 받은 데이터가 담긴 객체
//		HttpServletResponse : 응답 방법을 제공하는 객체
		
//		요청 시 제출된 값(파라미터) 모두 얻어오기
		
//		1) 값이 하나인 경우 : String req.getParameter("name")
		String chicken = req.getParameter("chicken");	// 치킨
		String type    = req.getParameter("type");		// 뼈 / 순살
		
		String orderName    = req.getParameter("orderName");
		String orderAddress = req.getParameter("orderAddress");
		
//		2) 값이 여러 개인 경우
		
//		ex) type="checkbox" 인풋을 얻어오는 법
		
//		String[] req.getParameterValues("name");
//		-> 제출된 값 중 name 속성 값이 일치하는 것을 모두 모아 하나의 String[] 로 반환
		
//		단, name 속성 값이 일치하는 게 없을 경우 "null" 반환
		
		String[] options = req.getParameterValues("opt");
		
//		-----------------------------------------------------
		/* 선택한 치킨, 뼈 / 순살, 옵션에 따라 가격 책정하기 */
		
		int price = 0;
		
		switch (chicken) {
		case "후라이드" : price += 10000; break;
		case "양념"     : price += 11000; break;
		case "마늘", "간장" : price += 12000; break;
		}
		
		if (type.equals("boneless")) price += 2000;
		
		if (options != null) {
			for (String opt :options) {
				switch (opt) {
				case "치킨무" : price += 500;  break;
				case "콜라"   : price += 2000; break;
				case "치즈볼" : price += 3000; break;
				}
			}
		}
		
//		---------------------------------------------
		
//		응답 HTML 만들어서 출력하기
		
//		응답 데이터의 형식 / 문자 인코딩 지정
		resp.setContentType("text/html; charset=utf-8");
		
//		출력용 스트림 얻어오기
		PrintWriter  out = resp.getWriter();
		StringBuilder sb = new StringBuilder();
		
		sb.append("""
				<!DOCTYPE html>
				<html>
				<head>
				<title>
				""");
		
		sb.append(orderName + "님의 주문 ");
		
		sb.append("""
				</title>
				</head>
				<body>
				""");
		
		sb.append("<h3> 주문자명 : " + orderName + "</h3>");
		sb.append("<h3> 주소 : " + orderAddress + "</h3>");
		
		sb.append("<ul>");
		sb.append("<li> 치킨 : " + chicken + "</li>");
		sb.append("<li> 뼈/순살 : " + (type.equals("bone") ? "뼈" : "순살") + "</li>");
		
		if (options != null) {
			sb.append("<li> 선택한 옵션 : ");
//			String[] 을 문자열로 반환
			sb.append(String.join(" / ", options));
			sb.append("</li>");
		}
		sb.append("</ul>");
		
		sb.append("<h3> 금액 : " + price + "</h3>");
		
		sb.append("""
				<hr>
				<button onclick='history.back()'>돌아가기</button>
				</body>
				</html>
				""");
		
		out.write(sb.toString());

	}
}











