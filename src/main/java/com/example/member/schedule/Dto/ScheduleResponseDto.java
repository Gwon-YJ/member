package com.example.member.schedule.Dto;

import com.example.member.schedule.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    // 1. 속성
    private final Long id; //  ID
    private final String title; // 할일 제목
    private final String contents; // 할일 내용
    private LocalDateTime updated_At;

    // 2. 생성자
    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.updated_At = schedule.getUpdated_At();
    }




}
