package com.example.member.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    // 1. 속성
    @CreatedDate
    @Column(updatable = false)
//    @Temporal(TemporalType.TIMESTAMP) 생략가능
    private LocalDateTime created_At; // 작성일

    @LastModifiedDate
    private LocalDateTime updated_At; // 수정일

    // 2. 생성자

    // 3. 기능
}
