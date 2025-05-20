package com.example.member.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {
    // 1. 속성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

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
