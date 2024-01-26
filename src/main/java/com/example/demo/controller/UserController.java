package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//@RestController // 리턴시 그 문자를 그대로 응답
// 디스패쳐 서블릿은 톰캣 이 만들어준다

@Controller  // 템플릿 엔진 파일 리턴해준다 : 리턴시 파일을 응답(foword)
public class UserController {

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";

    }

    @PostMapping("/join")
    public String join(String username, String password, String email) {
        //        String username = request.getParameter("username");
        //        String password = request.getParameter("password");
        //        String email = request.getParameter("email");

        System.out.println("username : " + username);
        System.out.println("password :" + password);
        System.out.println("email :" + email);

        //유효성검사
        if (username.length() > 10) {
            return "error-404";
        }
        //만들어놓은 컨트롤러가 있으면 view 를 하면 안된다.
        //리다이렉트로 접속
        return "redirect:/main"; //리다이렉트
    }

}
