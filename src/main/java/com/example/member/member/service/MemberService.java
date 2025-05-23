package com.example.member.member.service;

import com.example.member.common.Dto.LoginRequestDto;
import com.example.member.common.Dto.LoginResponseDto;
import com.example.member.member.Dto.MemberResponseDto;
import com.example.member.common.Dto.SignUpResponseDto;
import com.example.member.member.entity.Member;
import com.example.member.member.repository.MemberRepository;
import com.example.member.schedule.entity.Schedule;
import com.example.member.schedule.repository.ScheduleRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    // 1. 속성
    private final MemberRepository memberRepository;
    private final ScheduleRepository scheduleRepository;

    // 2. 생성자

    // 3. 기능
    // 회원 생성
    public LoginResponseDto login(LoginRequestDto requestDto) {
        // 1. 이메일로 회원 조회 (Optional에서 꺼내기)
        Member member = memberRepository.findMemberByEmail(requestDto.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "이메일이 없습니다."));

        // 2. 비밀번호 검증
        if (!member.getPassword().equals(requestDto.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 틀렸습니다.");
        }

        // 6. 로그인 성공 시 반환할 DTO 생성 및 반환
        return new LoginResponseDto(member.getId());
    }

    public SignUpResponseDto signUp(String username, String password, String email) {

        Member member = new Member(username, password, email);

        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getEmail());
    }

    // 회원 조회
    public MemberResponseDto findById(Long id) {

        Optional<Member> optionalMember = memberRepository.findById(id);

        // NPE 방지
        if (optionalMember.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        Member findMember = optionalMember.get();

        return new MemberResponseDto(findMember.getUsername(), findMember.getEmail());
    }

    // 일정 수정
    public MemberResponseDto updateMember(Long id, String username, String password, String email) {
        Member updateMember = memberRepository.findByIdOrElseThrow(id);
        Schedule updateSchedule = scheduleRepository.findByIdOrElseThrow(id);
        if (!updateSchedule.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        updateMember.setUsername(username);
        updateMember.setEmail(email);

        Member save = memberRepository.save(updateMember);
        return new MemberResponseDto(save.getUsername(),save.getEmail());
    }

    // 비밀번호 수정
    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {

        Member findMember = memberRepository.findByIdOrElseThrow(id);

        if (!findMember.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        findMember.updatePassword(newPassword);
    }
    // 회원 삭제
    public void delete(Long id) {

        Member findMember = memberRepository.findByIdOrElseThrow(id);

        memberRepository.delete(findMember);
    }
}
