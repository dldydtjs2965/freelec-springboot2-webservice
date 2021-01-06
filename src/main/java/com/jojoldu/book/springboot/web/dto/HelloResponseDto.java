package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //선언된 모든 필드의 get메서드를 생성
@RequiredArgsConstructor // 선언된 모든 final필드가 포함된거만 생성자 생성.
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
