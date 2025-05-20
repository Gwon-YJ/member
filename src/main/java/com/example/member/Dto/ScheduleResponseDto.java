package com.example.member.Dto;

import com.example.member.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    // 1. 속성
    private final Long id; //  ID
    private final String title; // 할일 제목
    private final String contents; // 할일 내용

    // 2. 생성자
    public ScheduleResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    // 3. 기능
    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents());
    }


}
