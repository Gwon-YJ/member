package com.example.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MemberApplication {
    // 1. 속성

    // 2. 생성자

    // 3. 기능
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }

}
