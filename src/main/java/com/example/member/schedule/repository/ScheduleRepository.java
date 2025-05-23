package com.example.member.schedule.repository;

import com.example.member.member.entity.Member;
import com.example.member.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // 1. 속성

    // 2. 생성자

    // 3. 기능
    // 일정 조회
    default Schedule findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }
}