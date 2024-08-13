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

@WebServlet("/member/delete")
public class DeleteSetvlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int index = Integer.parseInt(req.getParameter("index"));
		String name = req.getParameter("name");
		
		try {
			MembershipService service = new MembershipServiceImpl();
			List<Member> searchList = service.selectName(name);
			
			Member target = searchList.get(index);
			
			boolean result = service.deleteMember(target);
			
			String message = null;
			
			if (result) message = name + " 회원이 탈퇴처리 되었습니다.";
			else 	    message = "### 탈퇴 실패 ###";
			
			req.setAttribute("searchList", service.selectName(name));
			
			req.getSession().setAttribute("message", message);
			
			String path = "/WEB-INF/views/read.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
