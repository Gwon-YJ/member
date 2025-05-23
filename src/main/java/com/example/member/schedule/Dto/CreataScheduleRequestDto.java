package com.example.member.schedule.Dto;

import lombok.Getter;


@Getter
public class CreataScheduleRequestDto {

    // 1. 속성
    private final String title; // 할일 제목
    private final String contents; // 할일 내용
    private final String password; // 작성 유저명

    // 2. 생성자
    public CreataScheduleRequestDto(String title, String contents, String password) {
        this.title = title;
        this.contents = contents;
        this.password = password;
    }

    // 3. 기능
}
