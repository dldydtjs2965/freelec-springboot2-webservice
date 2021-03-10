package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // jap aduting 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class);
        //톰캣이 아닌 내장 WAS실행.
    }
}
