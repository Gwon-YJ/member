package com.example.member.schedule.Dto;

import lombok.Getter;

@Getter
public class UpdateScheduleDto {
    // 1. 속성
    private String title;
    private String contents;
    private String password;

    // 2. 생성자
    public UpdateScheduleDto(String title, String contents, String password) {
        this.title = title;
        this.contents = contents;
        this.password = password;
    }

    // 3. 기능
}
