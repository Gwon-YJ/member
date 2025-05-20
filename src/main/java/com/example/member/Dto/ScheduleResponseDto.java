package com.example.member.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table()
public class ScheduleResponseDto {

    @Id
    private Long id;

}
