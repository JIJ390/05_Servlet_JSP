<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 추가</title>
  <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
  <h2>신규 회원 정보 입력</h2>

  <div class="container">
    <form action="/member/add" method="POST" class="menu">
      <div class="menu-item">
        이름
        <br>
        <input type="text" name="name" required>
      </div>
      <div  class="menu-item">
        휴대폰 번호 
        <br>
        <input type="tel" name="phone" placeholder="('-' 제외, 11 자리 숫자)" pattern="[0-9]{11}" required>
      </div>

      <button class="button">추가하기</button>
    </form>
  
  </div>

  <br>

  <a href="/"><button class="button">목록으로</button></a>


  <c:if test="${not empty sessionScope.message}" >
    <script>
      alert("${message}");
    </script>
    <c:remove var="message" scope="session" />
  </c:if>
</body>
</html>