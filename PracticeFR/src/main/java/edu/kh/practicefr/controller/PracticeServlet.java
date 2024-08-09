package edu.kh.practicefr.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class PracticeServlet extends HttpServlet{
	
	private List<String> nameList = null;
	
	public PracticeServlet()	 {
		nameList = new ArrayList<String>();
		
		nameList.add("짱구");
		nameList.add("훈이");
		nameList.add("철수");
		nameList.add("유리");
		nameList.add("맹구");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String inputName = req.getParameter("inputName");
		
//		값 과 일치하는 요소의 index 반환 / 없으면 -1 반환!
		int index = nameList.indexOf(inputName);
		
		if (index > -1) {
			
			String message = inputName + " 님은 " + index + " 번째 인덱스에 존재합니다.";
			req.setAttribute("message", message);
			
//			WEB-INF 폴더는 클라이언트 직접 접근 불가
			String path = "/WEB-INF/views/result.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} else {
			
//			HttpSession session = req.getSession();
//			
//			session.setAttribute("message", 
//								inputName + "님은 존재하지 않습니다");
//			
			req.getSession().setAttribute("message", inputName + " 님은 존재하지 않습니다.");
//			왜 message를 session scope에 세팅했을까??
//			-> redirect(재요청) 시 
//			   기존 req/resp 객체가 사라지고
//			   새 req/resp 객체가 생성되기 때문에
			
//			기존 req에 값을 세팅해봐야 없어지기 때문에 의미 없음
			resp.sendRedirect("/");
//			메인 페이지(/) 재요청하기
//			-> webapp 폴더를 기준으로 파일 경로 작성
//			   또는
//			원하는 Servlet의 매핑되는 주소 작성
			

		}
		
			
	}
}




















