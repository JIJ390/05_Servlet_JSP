package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/el_jstl")
public class ElJstlServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
//		webapp 폴더 기준 경로
		String path = "/WEB-INF/views/el_jstl.jsp";
//		요청 발송자(배달부)
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
//		위임 메서드
		dispatcher.forward(req, resp);
		
	}
}
