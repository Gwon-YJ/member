package com.example.member.common.Dto;

import lombok.Getter;

@Getter
public class SignUpResponseDto {
    // 1. 속성
    private final Long id;  // ID
    private final String username; // 작성 유저명
    private final String email; // 이메일

    // 2. 생성자
    public SignUpResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    // 3. 기능
}
