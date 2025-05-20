package com.example.member.Dto;

import com.example.member.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleWithAgeResponseDto {
    // 1. 속성
    private final String title;

    private final String contents;

    private final Integer age;

    // 2. 생성자
    public ScheduleWithAgeResponseDto(String title, String contents, Integer age) {
        this.title = title;
        this.contents = contents;
        this.age = age;
    }

}
