<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>로그인 결과 페이지</title>
</head>
<body>
  <h1>로그인 결과</h1>
  <hr>

  <% if (request.getParameter("id").equals("user01") && 
         request.getParameter("pw").equals("pass01")) { %>
      <h3 style='color:blue'>로그인 성공!</h3>
  <% } else { %>
      <h3 style='color:red'>로그인 실패</h3>
      - 아이디 혹은 비밀번호가 일치하지 않습니다
      <% } %>

  <br><br>
  <hr>
  <button onclick='history.back()'>돌아가기</button>
</body>
</html>