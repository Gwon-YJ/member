package com.example.member.common.Dto;

import lombok.Getter;

@Getter
public class LoginRequestDto {

    private String email;
    private String password;

    // 기본 생성자, 필요하면 @NoArgsConstructor도 추가
    public LoginRequestDto() {

    }

    // 생성자, 필요에 따라 추가 가능
    public LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;

    }
}
