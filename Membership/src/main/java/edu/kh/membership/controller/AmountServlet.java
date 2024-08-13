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

@WebServlet("/member/amount")
public class AmountServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int index = Integer.parseInt(req.getParameter("index"));
		int acc = Integer.parseInt(req.getParameter("acc"));
		String name = req.getParameter("name");
		
		try {
			MembershipService service = new MembershipServiceImpl();
			List<Member> searchList = service.selectName(name);
			
			Member target = searchList.get(index);
			
			String[] message = service.updateAmount(target, acc);
			
			req.setAttribute("searchList", service.selectName(name));
			
			req.getSession().setAttribute("message", message[0]);
			req.getSession().setAttribute("message2", message[1]);
			
			String path = "/WEB-INF/views/read.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
