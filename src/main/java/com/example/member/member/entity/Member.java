package com.example.member.member.entity;

import com.example.member.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "member")
public class Member extends BaseEntity {
    // 1. 속성
    @Id // 고유 ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //겹치지 않게 만들어주는 것
    private Long id; //식별자

    @Column(nullable = false, unique = true)
    private String username; // 작성 유저명

    @Column(nullable = false)
    private String password; // 비밀번호

    private String email; // 이메일

    // 2. 생성자
    public Member() {
    }

    public Member(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // 3. 기능
    public void updatePassword(String password) {
        this.password = password;
    }

    // 3. 기능
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
