package com.example.member.service;


import com.example.member.Dto.ScheduleResponseDto;
import com.example.member.Dto.ScheduleWithAgeResponseDto;
import com.example.member.Dto.SignUpResponseDto;
import com.example.member.entity.Member;
import com.example.member.entity.Schedule;
import com.example.member.repository.MemberRepository;
import com.example.member.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public ScheduleResponseDto save(String title, String contents, String username) {

        Member findMember = memberRepository.findMemberByUsernameOrElseThrow(username);

        Schedule schedule = new Schedule(title, contents);
        schedule.setMember(findMember);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents());
    }

    // 일정 전체 조회
    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    // 일정 단건 조회
    public ScheduleWithAgeResponseDto findById(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        Member writer = findSchedule.getMember();

        return new ScheduleWithAgeResponseDto(findSchedule.getTitle(), findSchedule.getContents(), writer.getAge());
    }

    // 일정 삭제
    public void delete(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);
    }
}
