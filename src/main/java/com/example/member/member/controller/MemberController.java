package com.example.member.member.controller;

import com.example.member.common.Dto.LoginRequestDto;
import com.example.member.common.Dto.LoginResponseDto;
import com.example.member.common.entity.Const;
import com.example.member.member.Dto.MemberResponseDto;
import com.example.member.common.Dto.SignUpRequestDto;
import com.example.member.common.Dto.SignUpResponseDto;
import com.example.member.member.Dto.UpdatePasswordRequestDto;
import com.example.member.member.Dto.UpdateMemberDto;
import com.example.member.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    // 1. 속성
    private final MemberService memberService;

    // 2. 생성자

    // 3. 기능
    // 회원 로그인 기능
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto requestDto, HttpServletRequest request) {
        LoginResponseDto responseDto = memberService.login(requestDto);

        HttpSession session = request.getSession();
        session.setAttribute(Const.LOGIN_USER,responseDto.getId());

        return ResponseEntity.ok(responseDto);
    }

    // 회원 생성 기능
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto =
                memberService.signUp(
                        requestDto.getUsername(),
                        requestDto.getPassword(),
                        requestDto.getEmail()
                );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    // 회원 조회 기능
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id) {

        MemberResponseDto memberResponseDto = memberService.findById(id);

        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    // 회원 수정 기능
    @PutMapping("/{id}")
    public ResponseEntity<MemberResponseDto>update(
            @PathVariable Long id,
            @RequestBody UpdateMemberDto updateMemberDto
    ) {

        MemberResponseDto memberResponseDto =  memberService.updateMember(id,updateMemberDto.getUsername(),updateMemberDto.getPassword(),updateMemberDto.getEmail());

        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    // 회원 비밀번호 수정 기능
    @PatchMapping("/{id}/password")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id,
            @RequestBody UpdatePasswordRequestDto requestDto
    ) {

        memberService.updatePassword(id, requestDto.getOldPassword(), requestDto.getNewPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 회원 삭제 기능
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        memberService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
