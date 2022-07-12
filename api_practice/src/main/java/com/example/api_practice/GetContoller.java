package com.example.api_practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/get-api")
public class GetContoller {

    // @RequestMapping을 사용한 메서드 구현
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "Hello World";
    }

    /*
    매개변수가 없는 GET 메서드 구현
        - Spring 4.3 버전 이후로는 새로 나온 어노테이션을 사용하기 때문에 @RequestMapping 어노테이션은 더 이상 사용되지 않는다.
        - Ex)
            - @GetMapping
            - @PostMapping
            - @PutMapping
            - @DeleteMapping
     */
    @GetMapping(value = "/name")
    public String getName(){
        return "Flature";
    }

}
