package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)//테스트용 메서드
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void mainPage_Loading(){
        //when
        String body = this.restTemplate.getForObject("/", String.class); // "/" 로 매핑된 페이지 호출

        //then
        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스"); //특정 문자열이 있는지 체크;
    }
}
