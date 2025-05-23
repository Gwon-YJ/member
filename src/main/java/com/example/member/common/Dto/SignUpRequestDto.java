package com.example.member.common.Dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {
    // 1. 속성
    private final String username; // 작성 유저명
    private final String password; // 비밀번호
    private final String email; // 이메일

    // 2. 생성자
    public SignUpRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // 3. 기능
}