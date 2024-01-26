package com.example.demo.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


// 프론트 컨트롤러 생성

@Controller
public class testController {

    //로그인 폼
    @GetMapping("/testform")
    public String testform() {
        return "testform";
    }

    //로그인 유효성 검사 페이지
    @PostMapping("/testjoin")
    public String join(String username, String password, String email) {

        System.out.println("username : " + username);
        System.out.println("password : " + password);
        System.out.println("email : " + email);

        if (username.length() > 10) {
            return "error-404";
        }

        return "redirect:/main"; //리다이렉트
    }
}
