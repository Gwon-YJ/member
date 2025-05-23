package com.example.member.schedule.entity;

import com.example.member.common.entity.BaseEntity;
import com.example.member.member.entity.Member;
import com.example.member.schedule.Dto.CreataScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {
    // 1. 속성
    @Id // 고유 ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 겹치치 않도록 해주는 것
    private Long id;

    @Column(nullable = false)
    private String title; // 할일 제목

    @Column(nullable = false)
    private String password; // 비밀번호

    @Column(columnDefinition = "longtext")
    private String contents; // 할일 내용

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member; // Member

    // 2. 생성자
    public Schedule() {
    }

    public Schedule(CreataScheduleRequestDto requestDto) {
      this.title = requestDto.getTitle();
      this.contents = requestDto.getContents();
      this.password = requestDto.getPassword();
    }

    // 3. 기능
    public void setMember(Member member) {
        this.member = member;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

}
