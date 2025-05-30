package com.example.member.member.repository;

import com.example.member.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {
    // 1. 속성

    // 2. 생성자

    // 3. 기능
    // 회원 수정 기능
    default Member findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }

    // 회원 생성 기능
    Optional<Member> findMemberByUsername(String username);

    default Member findMemberByUsernameOrElseThrow(String username) {
        return findMemberByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist username = " + username));
    }

    Optional<Member> findMemberByEmail(String email);

    Optional<Member> findMemberByPassword(String password);
}


