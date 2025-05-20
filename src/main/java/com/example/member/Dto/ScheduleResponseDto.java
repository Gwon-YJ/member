package com.example.member.Dto;

import com.example.member.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    // 1. 속성
    private final Long id;

    private final String title;

    private final String contents;

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
