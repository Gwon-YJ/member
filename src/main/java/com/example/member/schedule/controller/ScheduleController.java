package com.example.member.schedule.controller;

import com.example.member.schedule.Dto.CreataScheduleRequestDto;
import com.example.member.schedule.Dto.ScheduleResponseDto;
import com.example.member.schedule.Dto.UpdateScheduleDto;
import com.example.member.schedule.service.ScheduleService;
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
    @PostMapping("/{memberId}")
    public ResponseEntity<ScheduleResponseDto> save(@PathVariable("memberId") Long id,
            @RequestBody CreataScheduleRequestDto requestDto) {
        ScheduleResponseDto scheduleResponseDto =
                scheduleService.save(
                        id, requestDto
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
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.findById(id);

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    // 일정 수정 기능
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto>update(@PathVariable Long id, @RequestBody UpdateScheduleDto updateScheduleDto) {

        ScheduleResponseDto scheduleResponseDto =  scheduleService.updateSchedule(id,updateScheduleDto.getTitle(),updateScheduleDto.getPassword(),updateScheduleDto.getContents());

    return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }



    // 일정 삭제 기능
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        scheduleService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
