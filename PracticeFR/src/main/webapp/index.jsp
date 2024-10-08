<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>forward / redirect 연습</title>
  <%-- webapp 폴더 내부에 존재하는 css 파일 요청해서 얻어오기 --%>
  <link rel="stylesheet" href="/resources/css/practice.css">
</head>
<body>
  <h1>forward / redirect 연습</h1>
  <hr>
  <h3>Dynamic Web Project 의 폴더 구조</h3>
  <pre>
    * src/main/java
      - Java 파일이 저장되는 폴더
      - 서버에서 동작하는 코드를 작성해서 모아둔 폴더
      - 컴파일 되어있는 상태로 아님
        -> 배포 시 컴파일 된 파일만 webapp 폴더로 옮기고 나머진 제외되는 폴더

    * src/main/webapp
      - 실제로 배포되는 웹 어플리케이션의 
        컴파일된 코드, 정적 자원(html, css js, image) 이
        모여있는 폴더
      
      - 그래서 파일 경로, 요청 주소 작성 시 
        webapp 폴더가 기준이 된다!!

      ex) 주소에 / : webapp 폴더의 index.jsp 요청

          foward 시 JSP 파일 경로 / : webapp 폴더 기준 

          css, js 파일 경로(==요청 주소) / :webapp 폴더 기준

    * src/main/webapp/WEB-INF 폴더
      - /WEB - INF 폴더는 클라이언트 요청으로 볼 수 없는 폴더
        -> 서버가 숨겨둠

      - 이럴꺼면 배포하는 webapp 폴더에 안넣으면 되는 거 아닌가?
        -> 직접 해당 파일을 보여줄 순 없지만
           응답화면 등의 웹 서비스를 제공하기 위해서는 
           필요하기 때문에 webapp 폴더에 존재해야 한다  
  </pre>

  <hr>
  <h1>List 에 같은 이름이 존재하는지 확인!</h1>
  <pre>
    - 이름을 하나 입력 받아 "/search", POST 방식으로 요청

    - Servlet 에 존재하는 이름이 모인 List에서 
      입력받은 이름과 같은 이름이 있는지 확인

    - 존재하는 경우 
      -> "OOO 님은 X 번째 인덱스에 존재합니다"
         문자열을 request sope 객체에 세팅하여 

         /WEB-INT/views/result.jsp 로 요청 위임해 결과 출력
         (forward)

    - 존재하지 않는 경우
      -> "OOO 님은 존재하지 않습니다"
         문자열을 session scope 에 세팅 후 
         "/" (메인페이지 == index.jsp)로 재요청하여 출력
         (redirect)
  </pre>

  <form action="/search" method="POST">
    검색할 이름 입력 : <input type="text" name="inputName">
    <button>검색</button>
  </form>


  <h1>${message}</h1>
  
  <%-- sessionScope 에 message가 있을 경우 제거하기 --%>
  <c:if test="${not empty sessionScope.message}" >
    <c:remove var="message" scope="session" />
  </c:if>

</body>
</html>