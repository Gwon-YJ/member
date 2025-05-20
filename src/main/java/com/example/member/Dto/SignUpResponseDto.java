package com.example.member.Dto;

import lombok.Getter;

@Getter
public class SignUpResponseDto {

    // 1. 속성
    private final Long id;

    private final String username;

    private final Integer age;

    // 2. 생성자
    public SignUpResponseDto(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    // 3. 기능
}
