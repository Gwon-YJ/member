package com.example.member.entity;

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

    @Column(columnDefinition = "longtext")
    private String contents; // 할일 내용

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member; // Member

    // 2. 생성자
    public Schedule() {
    }

    public Schedule(String title, String contents) {
      this.title = title;
      this.contents = contents;
    }

    // 3. 기능
    public void setMember(Member member) {
        this.member = member;
    }
}
