package com.example.api_practice.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/*
    <PostController>
    - 일반적으로 POST 형식의 요청은 클라이언트가 서버에 리소스를 저장하는 데 사용함.
    - 그러므로 클라이언트의 요청 트래픽에 값이 포함돼 있음.
    - 즉, POST 요청에서는 리소스를 담기 위해 HTTP Body에 값을 넣어 전송함.
    - Body는 일반적으로 JSON 형식으로 전송됨.
 */
@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    /*
       @RequestBody와 Map을 활용한 POST API 구현
        - @RequestBody 어노테이션은 HTTP의 Body 내용을 해당 어노테이션이 지정된 객체에 매핑하는 역할을 함.
        - Map 객체는 요청을 통해 어떤 값이 들어오게 될지 특정하기 어려울 때 주로 사용함.
     */
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }
}
