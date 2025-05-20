package com.example.member.Dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    // 1. 속성
    private final String username; // 작성 유저명

    private final String password; // 비밀번호

    private final Integer age; // 나이

    // 2. 생성자
    public SignUpRequestDto(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    // 3. 기능
}