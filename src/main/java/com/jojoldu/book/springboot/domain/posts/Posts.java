package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter//클래스 내 ㅁ든 필드의 Getter 메소드를 자동생성
@NoArgsConstructor//기본 생성자 자동추가
@Entity //테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {
    @Id //해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk생성 규칙을 데이터베이스가 생성토록함.
    private  long id;

    @Column(length = 500, nullable = false)//테이블 칼럼을 나타내며 선언하지 않더라도 해당클래스의 필드는 모두 칼럼이됨
    private String title;

    @Column(columnDefinition = "Text", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
