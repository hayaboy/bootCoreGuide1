package com.example.bootcoreguide1;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
@WebMvcTest //여러 스프링 테스트 어노테이션 중 Web( Spring MVC)에 집중할 수 있는 어노테이션, 선언할 경우 @Controller, @ControllerAdvice등을 사용할 수 있습니다. 단, @Service, @Component, @Repository 등은 사용할 수 없습니다.
public class HelloControllerTest {
    
    @Autowired // 스프링이 관리하는 빈을 주입 받습니다.
    private MockMvc mockMvc;  //웹 API를 테스트할 때 사용, 스프링 MVC 테스트의 시작점, 이 클래스를 통해 HTTP GET, POST 등에 대한  API 테스트를 할 수 있습니다.
    
    @Test
    public void hello() throws Exception{
        String hello="hello";

        //mockMvc.perform(get("/hello")) MockMvc를 통해 /hello 주소로 HTTP GET 요청
        //andExpect(status().isOk()) Http Header의 status를 검증(200은 성공)
        mockMvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
    }
    
    
}
