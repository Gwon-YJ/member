package com.example.member.schedule.service;


import com.example.member.schedule.Dto.CreataScheduleRequestDto;
import com.example.member.schedule.Dto.ScheduleResponseDto;
import com.example.member.member.entity.Member;
import com.example.member.schedule.entity.Schedule;
import com.example.member.member.repository.MemberRepository;
import com.example.member.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ScheduleService {

    // 1. 속성
    private final MemberRepository memberRepository;
    private final ScheduleRepository scheduleRepository;

    // 2. 생성자

    // 3. 기능
    // 일정 생성
    public ScheduleResponseDto save(Long id, CreataScheduleRequestDto requestDto) {

        Member findMember = memberRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Schedule schedule = new Schedule(requestDto);
        schedule.setMember(findMember);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule);
    }

    // 일정 전체 조회
    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::new)
                .toList();
    }

    // 일정 단건 조회
    public ScheduleResponseDto findById(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        return new ScheduleResponseDto(findSchedule);
    }

    // 일정 수정
    public ScheduleResponseDto updateSchedule(Long id, String title, String password, String contents) {
        Schedule updateSchedule = scheduleRepository.findByIdOrElseThrow(id);
        Member updateMember = memberRepository.findByIdOrElseThrow(id);
        if (!updateMember.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        updateSchedule.setTitle(title);
        updateSchedule.setContents(contents);

        Schedule save = scheduleRepository.save(updateSchedule);
        return new ScheduleResponseDto(save);
    }

    // 일정 삭제
    public void delete(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);
    }
}
