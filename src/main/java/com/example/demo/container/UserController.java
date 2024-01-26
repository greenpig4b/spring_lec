package com.example.demo.container;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    //로그인 폼

    @GetMapping("/loginform")
    public String loginform() {
        return "loginform";
    }

    //유효성 검사

    @PostMapping("/loginformtest")
    public String logintest(String username, String password, String email) {
        System.out.println("username : " + username);
        System.out.println("password : " + password);
        System.out.println("email : " + email);

        if (username.length() > 12) {
            // 유효성검사를 통과하지못하면 에러페이지 호출
            return "error-404";
        }
        // 검사 통과하면 메인페이지 호출
        return "redirect:/main";
    }

}
