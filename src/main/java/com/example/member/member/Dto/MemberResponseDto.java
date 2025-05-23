package com.example.member.member.Dto;

import lombok.Getter;

@Getter
public class MemberResponseDto {
    // 1. 속성
    private final String username; // 작성 유저명
    private final String email; // 이메일

    // 2. 생성자
    public MemberResponseDto(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // 3. 기능
}

