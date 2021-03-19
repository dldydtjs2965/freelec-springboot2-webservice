package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor //초기화 되지않은 final 필드나 @notnull이 붙은 필드에 생성자를 생성
@RestController //Json 형태로 객체 데이터를 반환하기위한 컨트롤러
public class PostApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts") // @RequestBody 어노테이션을 이용하면 HTTP 요청 Body를 자바 객체로 저장.
    public long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}") //기존의 Mapping 정보를 수정하는데 사용.
    public long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}") //특정 핸들링 메서드에 매핑하기위하
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
