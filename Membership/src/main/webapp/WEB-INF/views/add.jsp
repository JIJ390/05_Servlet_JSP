<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 추가</title>
</head>
<body>
  <h2>신규 회원 정보 입력</h2>
  <hr>
  <form action="/member/add" method="POST">
    이름 : <input type="text" name="name">
    <br>
    전화 번호('-' 제외) : <input type="number" name="phone">
    <br>
    <button>추가하기</button>
  </form>

  <a href="/"><button>목록으로</button></a>


  <c:if test="${not empty sessionScope.message}" >
    <script>
      alert("${message}");
    </script>
    <c:remove var="message" scope="session" />
  </c:if>
</body>
</html>