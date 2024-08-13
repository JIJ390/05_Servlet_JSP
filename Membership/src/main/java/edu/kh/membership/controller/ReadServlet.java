package edu.kh.membership.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.membership.dto.Member;
import edu.kh.membership.service.MembershipService;
import edu.kh.membership.service.MembershipServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/read")
public class ReadServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");

		try {
			MembershipService service = new MembershipServiceImpl();
			
			List<Member> searchList = service.selectName(name);
			
			if (searchList.size() == 0) {
				String message = "조회된 결과가 없습니다";
				req.setAttribute("message", message);
			}
			
			req.setAttribute("searchList", searchList);
			
			String path = "/WEB-INF/views/read.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
