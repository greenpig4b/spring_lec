<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    String userName = request.getParameter("username");
    String password = request.getParameter("password");
    String email = request.getParameter("email");

    System.out.println("username : "+ userName );
    System.out.println("password : "+ password );
    System.out.println("email : "+ email );


    if (userName.length() < 3 || userName.length() > 10){

        response.getWriter().println("<h1>유저네임의 글자수가 3~10 사이어야합니다.</h1>");
        return;
    }

    response.setStatus(302);
    response.setHeader("Location","/main.do"); // 직접 Location 넣음
    response.setHeader("clock","12pm");

%>
