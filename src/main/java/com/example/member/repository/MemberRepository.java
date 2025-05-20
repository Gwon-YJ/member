package com.example.member.repository;

import com.example.member.entity.Member;
import com.example.member.entity.Schedule;
import jdk.dynalink.beans.MissingMemberHandlerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

// 비밀번호 수정 기능
public interface MemberRepository extends JpaRepository<Schedule, Long> {
    default Member findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }

    // 일정 생성 기능
    Optional<Member> findMemberByUsername(String username);

    default Member findByUsernameOrElseThrow(String username) {
        return findByUsernameOrElseThrow(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist username = " + username));
    }
}
