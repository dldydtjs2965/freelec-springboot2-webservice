package com.jojoldu.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postRepository;

    @After //Junit에서 단위 테스트가 끝날때마다 수행되는 메소드를 지정.
    public void cleanup(){
        postRepository.deleteAll();
    }

    @Test
    public void post_import(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postRepository.save(Posts.builder() //테이블에 posts에 insert/update 쿼리를 실행
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .build());

        //when
        List<Posts> postsList = postRepository.findAll(); //테이블 posts에 있는 모든 데이터를 조회해오는 메소드

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_add (){
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        List<Posts> postsList = postRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>>  createDate=" + posts.getCreatedDate() + ",  modifiedDate=" +posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
