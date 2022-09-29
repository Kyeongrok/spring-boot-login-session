package com.bbs.adapter.outgoing.dto;

import lombok.Getter;

@Getter
public class LoginForm {
    private String loginId;
    private String password;

    public void setLoginId(String loginId) {
        if (loginId == null){
            throw new IllegalArgumentException("loginId cannot be null");
        }
        this.loginId = loginId;
    }

    public void setPassword(String password) {
        if (password == null){
            throw new IllegalArgumentException("password cannot be null");
        }
        this.password = password;
    }
}
