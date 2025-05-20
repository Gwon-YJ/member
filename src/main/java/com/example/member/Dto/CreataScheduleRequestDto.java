package com.example.member.Dto;

import lombok.Getter;

import java.util.StringTokenizer;

@Getter
public class CreataScheduleRequestDto {

    // 1. 속성
    private final String title;

    private final String contents;

    private final String username;

    // 2. 생성자
    public CreataScheduleRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }
    // 3. 기능
}
