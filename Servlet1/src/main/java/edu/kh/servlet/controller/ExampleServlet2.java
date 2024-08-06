package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
/* [Servlet 용도의 클래스 생성 시 해야 할 것]
 * 1. HttpServlet 상속 받기 
 * 
 * 2. @WebServlet("요청주소") 어노테이션 작성하기
 * 
 * 3. doGet() 또는 doPost() 오버라이딩 하기
 */
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 어노테이션(Annotation) : 컴파일러가 읽고 해석하는 주석

// @WebServlet("요청주소") 
// - 컴파일 시 web.xml 파일에 해당 클래스를 Servlet으로 등록하는 
//   <servlet> 태그 작성하고
//   "요청주소" 와 매핑 되도록 <servlet-mapping> 태그 작성하게 함

// *** 주의 사항 *** : 요청 주소는 반드시 "/" 부터 시작해야 한다!!!
@WebServlet("/ex2")
public class ExampleServlet2 extends HttpServlet{
//	"/ex2" GET 방식 요청 처리 메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		제출된 파라미터를 모두 얻어와 변수에 저장
		int num1 = Integer.parseInt(req.getParameter("input1"));
		int num2 = Integer.parseInt(req.getParameter("input2"));
		String op = req.getParameter("op");
		
		int result = 0;
		String operator = null;
		
		switch (op) {
		case "plus"  : result = num1 + num2; operator = "+"; break;	
		case "minus" : result = num1 - num2; operator = "-"; break;	
		case "multi" : result = num1 * num2; operator = "*"; break;	
		case "div"   : result = num1 / num2; operator = "/"; break;	
		case "mod"   : result = num1 % num2; operator = "%"; break;	
		}
		
//		응답 페이지 만들기
		resp.setContentType("text/html; charset-UTF-8");
		
		PrintWriter out = resp.getWriter();
		StringBuilder sb = new StringBuilder();
		
		
//		<meta charset='UTF-8'> 헤드 태그에 작성		
		sb.append("""
				<!DOCTYPE html>
				<html>
				<head>
					<title> /ex2 연산 결과 페이지 </title>
				</head>
				<body>
				<h1>
				""");
		
//		sb.append(String.format("%d %s %d = %d ", num1, operator, num2, result));		
		sb.append(num1);
		sb.append(" ");
		sb.append(operator);
		sb.append(" ");
		sb.append(num2);
		sb.append(" = ");
		sb.append(result);
		
		sb.append("""
				</h1>
				<button onclick='history.back()'>돌아가기</button>
				</body>
				</html>
				""");
		
		out.write(sb.toString());
	}

}

















