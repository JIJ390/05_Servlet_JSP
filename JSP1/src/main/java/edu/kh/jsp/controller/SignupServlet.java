package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* 별도 데이터 처리 없이 바로 JSP 로 요청 위임 */
		
		String path = "/WEB-INF/views/signup_result.jsp";
//		요청 발송자(RequestDispatcher) 객체 얻어오기 
//		+ JSP 경로 매개 변수에 작성
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		dispatcher.forward(req, resp);
	}

	
}
