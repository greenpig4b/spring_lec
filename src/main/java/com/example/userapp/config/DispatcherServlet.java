package com.example.userapp.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

//FrontController
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 공통로직
        resp.setHeader("Content-Type","text/html; charset= utf-8");
        System.out.println("common logic");
        LocalDateTime now = LocalDateTime.now();

        //2. 분기처리
        String uri = req.getRequestURI(); // 포트번호 뒤에 파싱해줌

        //라우터

        if (uri.equals("/join-form.do")){
            //resp.sendRedirect("/WEB-INF/user/join-form.jsp");
            req.getRequestDispatcher("/WEB-INF/user/join-form.jsp").forward(req, resp); // 내부적요청
        }else if (uri.equals("/join.do")){
            //resp.sendRedirect("/user/join.jsp");
            req.getRequestDispatcher("/WEB-INF/user/join.jsp").forward(req, resp); // 내부적요청
        }else if (uri.equals("/main.do")){
            //resp.sendRedirect("/board/main.jsp");
            req.getRequestDispatcher("/WEB-INF/board/main.jsp").forward(req, resp); // 내부적요청
        }else{
            resp.setStatus(404);
            resp.getWriter().println("잘못된 페이지 요청입니다");
        }

        //3.
    }
}
