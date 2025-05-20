package com.example.member.Dto;

import lombok.Getter;

@Getter
public class MemberResponseDto {

    // 1. 속성
    private final String username; // 유저이름

    private final Integer age; // 나이

    // 2. 생성자
    public MemberResponseDto(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    // 3. 기능
}