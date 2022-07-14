package com.example.api_practice.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
