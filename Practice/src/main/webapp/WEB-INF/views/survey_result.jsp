<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>만족도 설문 결과</title>
</head>
<body>
  <h1>만족도 설문 결과</h1>

  <hr>

  <ul>
    <li>가격 : ${param.price}</li>
    <li>서비스 : ${param.service}</li>
    <li>상영 영화 다양성 : ${param.movie}</li>
  </ul>

<%--   <% int value = request.getParameter("price") +
                 request.getParameter("service") +
                 request.getParameter("movie"); %> --%>

  <c:if test="${param.price + param.service + param.movie >= 10}">
    <h3>만족도 상</h3>
  </c:if>
  <c:if test="${param.price + param.service + param.movie < 10 &&
                param.price + param.service + param.movie >= 5}">
    <h3>만족도 중</h3>
  </c:if>
  <c:if test="${param.price + param.service + param.movie < 5}">
    <h3>만족도 하</h3>
  </c:if>


  <button id="returnBtn">돌아가기</button>
	
	<script>
		document.querySelector("#returnBtn").addEventListener("click", () => {
			alert("돌아갑니다");
			history.back();
		})
	</script>

  <br><br>
  <hr>
</body>
</html>