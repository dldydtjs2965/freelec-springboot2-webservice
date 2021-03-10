package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들도 칼럼(createdDate,modifieDate)으로 인식
@EntityListeners(AuditingEntityListener.class)//BaseTimeEntity클래스에 Auditing 기능을 포함 -auditing: 업뎃시 자동으로 시간넣음
public class BaseTimeEntity {

    @CreatedDate //Entity가 생성되어 저장될때 시간이 자동저장.
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 entity의 값을 변경할 때 시간이 자동 저장됨.
    private LocalDateTime modifiedDate;
}
