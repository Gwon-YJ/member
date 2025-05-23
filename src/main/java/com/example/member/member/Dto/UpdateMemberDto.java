package com.example.member.member.Dto;

import lombok.Getter;

@Getter
public class UpdateMemberDto {
    // 1. 속성
    private String username;
    private String password;
    private String email;

    // 2. 생성자
    public UpdateMemberDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // 3. 기능
}
