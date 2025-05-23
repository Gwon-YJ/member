package com.example.member.common.Dto;


import lombok.Getter;

@Getter
public class LoginResponseDto {
    private final Long id;
    // 추가 응답필드가 있다면 여기에 추가

    public LoginResponseDto(Long id) {
        this.id = id;
    }
}
