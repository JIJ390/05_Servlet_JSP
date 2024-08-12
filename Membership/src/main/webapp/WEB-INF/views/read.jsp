<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>이름으로 검색</title>
  <link rel="stylesheet" href="/resources/css/read.css">
</head>
<body>
  <h3>이름으로 검색</h3>
  <hr>
  <form action="/member/read" method="POST">
    <button>검색</button> 
    <input type="text" name="name">
  </form>
   
  <hr>
   
  ${searchList}

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
      <c:forEach items="${searchList}" var="search">
        <tr>
          <td>${search.name}</td>
          <td>${search.phone}</td>
          <td>${search.amount}</td>
          <td>${search.grade}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

</body>
</html>