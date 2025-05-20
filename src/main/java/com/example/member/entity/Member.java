package com.example.member.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "member")
public class Member extends BaseEntity {
    // 1. 속성
    @Id // 고유 ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //겹치지 않게 만들어주는 것
    private Long id;

    @Column(nullable = false, unique = true)
    private String username; // 유저이름

    @Column(nullable = false)
    private String password; // 비밀번호

    private Integer age; // 나이

    // 2. 생성자
    public Member() {
    }

    public Member(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    // 3. 기능
    public void updatePassword(String password) {
        this.password = password;
    }
}
