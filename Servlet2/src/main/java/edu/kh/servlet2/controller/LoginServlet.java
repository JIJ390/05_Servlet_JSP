package edu.kh.servlet2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 해당 클래스를 Servlet 으로 등록 + "/login" 요청 주소 처리하도록 매핑
// 주소 작성 항상 확인 !!!!!!!!!!!!!!!!!!!
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
//	form method="Post" 이므로 doPost 오버라이딩
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inputId = req.getParameter("inputId");
		String inputPw = req.getParameter("inputPw");
		String check   = req.getParameter("check");
		
		System.out.println(inputId);
		System.out.println(inputPw);
		System.out.println(check);
//		확인 안되면 서버 재시작
//		네트워크 탭 페이로드를 통해 넘어간 데이터 확인 가능
//		요청 응답 어떤 식으로 진행되는지 확인!!!!
		
//		----------------------------------------------------
		
//		아이디   : user01
//		비밀번호 : pass01!
//		check    : 헬로 월드
		
//		모두 일치 하는 경우 -> "로그인 성공"
//		불일치한 내용이 있을 경우
//		-> OOO 이 일치하지 않습니다 (ID, PW, CHECK)
		
		String result = "";
		
		if (inputId.equals("user01") && inputPw.equals("pass01!") && check.equals("헬로 월드")) {
			result = "<h1 style='color:red'> 로그인 성공 </h1>";
		} else {
			if (!inputId.equals("user01"))  result += "<h3> ID 가 일치하지 않습니다 </h3>";
			if (!inputPw.equals("pass01!")) result += "<h3> PW 가 일치하지 않습니다 </h3>";
			if (!check.equals("헬로 월드")) result += "<h3> CHECK 가 일치하지 않습니다 </h3>";
		}
		
//		응답되는 문서의 형식, 문자 인코딩 지정
		resp.setContentType("text/html; charset-UTF-8");
		PrintWriter out = resp.getWriter();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("""
				<!DOCTYPE html>
				<html>
				<head>
					<title> 로그인 결과 페이지 </title>
				</head>
				<body> """);
		
		sb.append(result);
		
		sb.append("""
				</body>
				</html> """);
		
		out.write(sb.toString());
	}
}
















