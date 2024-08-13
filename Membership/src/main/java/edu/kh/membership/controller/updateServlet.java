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

@WebServlet("/member/update")
public class updateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int index = Integer.parseInt(req.getParameter("index"));
		String name = req.getParameter("name");
		
		String path = "/WEB-INF/views/update.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int index = Integer.parseInt(req.getParameter("index"));
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		
		try {
			MembershipService service = new MembershipServiceImpl();
			List<Member> searchList = service.selectName(name);
			
			Member target = searchList.get(index);
			
			String message = service.updateMember(target, phone);
			
			req.getSession().setAttribute("message", message);
			
			req.setAttribute("searchList", service.selectName(name));
			
			String path = "/WEB-INF/views/read.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
