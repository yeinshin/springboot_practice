package com.example.api_practice.controller;

import org.springframework.web.bind.annotation.*;

/*
    <GetController>
    - 웹 애플리케이션 서버를 거쳐 데이터베이스 등의 저장소에 있는 리소스를 삭제할 때 사용.
    - 서버에서는 클라이언트로부터 리소스를 식별할 수 있는 값을 받아 데이터베이스나 캐시에 있는 리소스를 조회하고 삭제하는 역할을 수행.
*/

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    //@Pathvariable을 활용한 DELETE 메서드 구현
    @DeleteMapping(value = "/{valiable}")
    public String DeleteVariable(@PathVariable String valiable){
        return valiable;
    }

    /*
       @RequestParam을 활용한 DELETE 메서드 구현
        - @RequestParam 어노테이션을 통해 쿼리스트링 값도 받을 수 있음.
        - Ex) http://localhost:8080/api/v1/delete-api/request?email=value
     */
    @DeleteMapping(value = "/request1")
    public String getReqeustParam1(@RequestParam String email){
        return "e-mail : " + email;
    }
}
