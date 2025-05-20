package com.example.member.Dto;

import lombok.Getter;

import java.util.StringTokenizer;

@Getter
public class CreataScheduleRequestDto {

    // 1. 속성
    private final String title; // 할일 제목
    private final String contents; // 할일 내용
    private final String username; // 작성 유저명

    // 2. 생성자
    public CreataScheduleRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }

    // 3. 기능
}
