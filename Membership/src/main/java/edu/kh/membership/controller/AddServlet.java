package edu.kh.membership.controller;

import java.io.IOException;

import edu.kh.membership.service.MembershipService;
import edu.kh.membership.service.MembershipServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/add")
public class AddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/add.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		
		if (name.equals("")) {
			req.getSession().setAttribute("message", "이름 없음");
			resp.sendRedirect("/member/add");
			return;
		}
		
		
		if (phone.length() != 11) {
			req.getSession().setAttribute("message", "전화 번호는 11자리로 입력해 주세요");
			resp.sendRedirect("/member/add");
			return;
		}
		
		try {
			MembershipService service = new MembershipServiceImpl();
			
			boolean result = service.addMember(name, phone);
			
			String message = null;
			
			if (result) message = "추가 성공";
			else 		message = "실패 : 중복되는 전화번호입니다";
			
			req.getSession().setAttribute("message", message);
			resp.sendRedirect("/member/add");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		

		
	}
}
