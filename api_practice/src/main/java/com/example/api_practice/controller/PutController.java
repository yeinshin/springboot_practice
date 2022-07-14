package com.example.api_practice.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*
    <PutController>
    - 웹 어플리케이션 서버를 통해 데이터베이스 같은 저장소에 존재하는 리소스 값을 업데이트 하는 데 사용함.
    - POST API와 비교하면 요청을 받아 실제 데이터베이스에 반영하는 과정(서베스 로직)에서 차이가 있지만 컨트롤러 클래스를 구현하는 방법은 POST API와 거의 동일함.
        -> 리소스를 서버에 전달하기 위해 HTTP Body를 활용해야 하기 때문.
 */
@RestController("/api/v1/put-api")
public class PutController {

    /*
       @RequestBody와 Map을 활용한 PUT 메서드 구현
        - PUT API는 POST 메서드와 마찬가지로 값을 HTTP Body에 담아 전달함.
        - 서버에서는 이 값을 받기 위해 @RequestBody를 사용함.
     */
    public String postMember(@RequestBody Map<String, Object> putData){
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }
}
