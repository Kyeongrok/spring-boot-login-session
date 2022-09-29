package com.bbs.adapter.incoming;

import com.bbs.domain.login.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;

    // GET으로 호출 했을 때 로그인 페이지로 이동
    @GetMapping("/login")
    public String loginForm() {
        return "login/loginForm";
    }

}
