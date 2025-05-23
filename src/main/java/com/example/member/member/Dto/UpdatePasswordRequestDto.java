package com.example.member.member.Dto;

import lombok.Getter;

@Getter
public class UpdatePasswordRequestDto {
    // 1. 속성
    private final String oldPassword; // 지난 비밀번호
    private final String newPassword; // 새로운 비밀번호

    // 2. 생성자
    public UpdatePasswordRequestDto(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    // 3. 기능
}

