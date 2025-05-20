package com.example.member.Dto;

import lombok.Getter;

@Getter
public class ScheduleWithAgeResponseDto {
    // 1. 속성
    private final String title; // 제목

    private final String contents; // 할일 내용

    private final Integer age; // 나이

    // 2. 생성자
    public ScheduleWithAgeResponseDto(String title, String contents, Integer age) {
        this.title = title;
        this.contents = contents;
        this.age = age;
    }

    // 3. 기능

}
