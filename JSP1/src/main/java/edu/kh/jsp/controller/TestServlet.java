package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		전달 받은 값을 
//		h1 태그의 각각 다른 색상으로 출력되도록 
//		HTML 코드를 작성하여 응답하기
		
//		req.getParameter("input1")		
//		-----------------------------------------------------------------
		/* 응답 처리 */
//		-> Servlet 이 직접 HTML 코드를 작성하지 않고
//		   JSP 한테 대신 화면을 만들어
//		   클라이언트에게 응답(출력) 하라고 요청을 떠넘기자
//		   -> 요청 위임
		
//		요청 위임 방법 1) 
//		떠넘길(위임할) JSP 경로 작성
//		-> webapp 폴더를 기준으로 경로 작성!!!
//		제일 앞 '/' == webapp 폴더
		
		String path = "/WEB-INF/views/test_result.jsp";
		
//		요청 위임 방법 2)
//		요청을 전달할 객체 (ResquestDispatcher) 얻어오기
//		-> 객체 얻어올 때 어떤 JSP 로 전달할 지 매개변수로 기입
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
//		요청 위임 방법 3) 
//		ResquestDispatcher 객체에게
//		HttpServletRequest   (요청 데이터)
//		HttpServletResponse  (응답 방법)
//		를 주고
//		JSP 로 떠넘기는(위임하는) 메서드 호출
		
		dispatcher.forward(req, resp);
		
		
	}
}































