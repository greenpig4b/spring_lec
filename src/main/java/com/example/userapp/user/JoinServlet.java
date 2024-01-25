package com.example.userapp.user;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
// 데이터가 xForm 형태로 들어옴
//@WebServlet("/join")
public class JoinServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type","text/html; charset= utf-8");
        // username=ssar&password=1234&email=ssar@nate.com

        //
        //        BufferedReader reader = req.getReader();
        //
        //        String requestBody = "";
        //
        //        while(true){
        //            String line = reader.readLine();
        //
        //            if (line == null) break;
        //
        //            requestBody = requestBody + line;
        //        }
        //        System.out.println(requestBody);

        // 버퍼리더는 소비하고나면 안에 내용은 비어있다.
        // FrontController에 담겨있어서 버퍼리더를 읽어도 읽을 수 없다.

        // 1.파싱
        String userName = req.getParameter("username"); // 톰캣에서 키값을 지원한다 input 에서  name값과 동일해야 사용가능
        String password = req.getParameter("password"); // 톰캣에서 키값을 지원한다
        String email = req.getParameter("email"); // 톰캣에서 키값을 지원한다

        System.out.println("username : "+ userName );
        System.out.println("password : "+ password );
        System.out.println("email : "+ email );

        // 2.유효성 검사 (프레임워크 사용 안 할시 1000줄이 넘어갈 수 도있음)
        if (userName.length() < 3 || userName.length() > 10){

            resp.getWriter().println("<h1>유저네임의 글자수가 3~10 사이어야합니다.</h1>");
            return;
        }

        // 3. DB연결

        // 4. DAO 의 insert 매서드의 호출

        // 5. 메인 페이지 그리기(비효율)
//        String html = "  \"<!DOCTYPE html>\\n\" +\n" +
//                "                \"<html lang=\\\"en\\\">\\n\" +\n" +
//                "                \"\\n\" +\n" +
//                "                \"<head>\\n\" +\n" +
//                "                \"    <meta charset=\\\"UTF-8\\\">\\n\" +\n" +
//                "                \"    <meta name=\\\"viewport\\\" content=\\\"width=device-width, initial-scale=1.0\\\">\\n\" +\n" +
//                "                \"    <title>Document</title>\\n\" +\n" +
//                "                \"</head>\\n\" +\n" +
//                "                \"\\n\" +\n" +
//                "                \"<body>\\n\" +\n" +
//                "                \"    <h1>메인 페이지</h1>\\n\" +\n" +
//                "                \"    <hr>\\n\" +\n" +
//                "                \"</body>\\n\" +\n" +
//                "                \"\\n\" +\n" +
//                "                \"</html>\"";
//        resp.getWriter().println(html);

        // 6. 리다이랙트
        // 프로토콜 300번대는 맨끝에 로케이션안에(uri 넣어서보냄)
        //resp.sendRedirect("/main");  톰캣

        resp.setStatus(302);  // 리다이렉션
        resp.setHeader("Location","/main"); // 직접 Location 넣음

        resp.setHeader("clock","12pm");
    }
}
