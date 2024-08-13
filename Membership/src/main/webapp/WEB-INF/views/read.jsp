<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>이름으로 검색</title>
  <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
  <h2>회원 개별 조회</h2>



  <form action="/member/read" method="GET" class="form">
    <input type="text" name="name" placeholder="이름으로 검색" required>
    <button class="button2">검색</button> 
  </form>

  <div class="container">
    <table border=1 id="memberList">
      <thead>
        <tr>
          <th>이름</th>
          <th>휴대폰 번호</th>
          <th>누적 금액</th>
          <th>등급</th> 
          <th colspan="2">-</th>      
        </tr>
      </thead>

      <tbody>
        <c:if test="${not empty requestScope.message}">
          <tr>
            <th colspan="5">${message}</th>
          </tr>
        </c:if>

        <c:forEach items="${searchList}" var="search" varStatus="vs">
          <tr>
            <td class="nameLink"><a href="/member/update?index=${vs.index}&name=${search.name}">${search.name}</a></td>
            <td>${search.phone}</td>
            <td>${search.amount}</td>
            <td>${search.grade}</td>
            <td><button name="amountBtn" class="button2">금액 누적</button></td>
            <td><button name="deleteBtn" class="button2">삭제</button></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>   



  <br>
  <a href="/"><button class="button">목록으로</button></a>


  <c:if test="${not empty sessionScope.message}" >
    <script>
      alert("${message}");
    </script>
    <c:remove var="message" scope="session" />
  </c:if>

  <c:if test="${not empty sessionScope.message2}" >
    <script>
      alert("${message2}");
    </script>
    <c:remove var="message2" scope="session" />
  </c:if>

  <script language=JavaScript>
    var arr = new Array();
    <c:forEach items="${searchList}" var="search" varStatus="vs">
      arr.push({name:"${search.name}"});
     </c:forEach>
  </script>

  <script src="/resources/js/read.js"></script>

</body>
</html>