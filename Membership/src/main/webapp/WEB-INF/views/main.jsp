<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/resources/css/main.css">
  <title>멤버 관리 페이지</title>
</head>
<body>
  <h1>회원 관리 페이지</h1>

  <h4>전체 회원 목록</h4>

  <div class="container">
    <table border=1 id="memberList">
      <thead>
        <tr>
          <th>이름</th>
          <th>휴대폰 번호</th>
          <th>누적 금액</th>
          <th>등급</th>        
        </tr>
      </thead>
      <tbody>
        <c:if test="${not empty requestScope.message}">
          <tr>
            <th colspan="5">${message}</th>
          </tr>
        </c:if>
        <c:forEach items="${memberList}" var="member">
          <tr>
            <td>${member.name}</td>
            <td>${member.phone}</td>
            <td>${member.amount}</td>
            <td>${member.grade}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

  </div>

  <br>
  <div class="container">
    <button id="readBtn" class="button">검색</button>
    <button id="addBtn" class="button">회원 추가</button>
  </div>  



  <script src="/resources/js/main.js"></script>

</body>
</html>