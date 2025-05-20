package com.example.member.controller;

import com.example.member.Dto.CreataScheduleRequestDto;
import com.example.member.Dto.ScheduleResponseDto;
import com.example.member.Dto.ScheduleWithAgeResponseDto;
import com.example.member.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@AllArgsConstructor
public class ScheduleController {
    // 1. 속성
    private ScheduleService scheduleService;

    // 2. 생성자

    // 3. 기능
    // 일정 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreataScheduleRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto =
                scheduleService.save(
                        requestDto.getTitle(),
                        requestDto.getContents(),
                        requestDto.getUsername()
        );

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);

    }

    // 일정 전체 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {

        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }

    // 일정 단건 조회 기능
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleWithAgeResponseDto> findById(@PathVariable Long id) {

        ScheduleWithAgeResponseDto scheduleWithAgeResponseDto = scheduleService.findById(id);

        return new ResponseEntity<>(scheduleWithAgeResponseDto, HttpStatus.OK);
    }


    // 일정 삭제 기능
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        scheduleService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
