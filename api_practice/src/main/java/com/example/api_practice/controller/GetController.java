package com.example.api_practice.controller;

import com.example.api_practice.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/get-api")
public class GetController {

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

    /*
       @PathVariable을 활용한 GET 메서드 구현
        - 실무 환경에서는 매개변수를 받지 않는 메서드가 거의 쓰이지 않는다.
        - 웹 통신의 기본 목적은 데이터를 주고받는 것이기 때문에 대부분 매개변수를 받는 메서드를 작성하게 된다.
        - 매개변수를 받을 때 자주 쓰이는 방법 중 하나는 URL 자체에 값을 담아 요청하는 것.
        - @GetMapping 어노테이션과 @PathVariable에 지정된 변수의 이름을 동일하게 맞춰야 한다.
     */
    @GetMapping(value = "/variable1/{variable}")
    public String getVarialbe1(@PathVariable String variable){
        return variable;
    }
    
    // @PathVariable을 활용한 GET 메서드 구현 (@GetMapping 어노테이션의 변수명 지정)
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    /*
       @RequestParam을 활용한 GET 메서드 구현
        - URI에서 '?'를 기준으로 우측에 '{키}={값}' 형태로 구성된 요청을 전송하여 @RequestParam을 활용해서 쿼리 값과 매핑하는 방법
        - Ex) http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
     */
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization ){
        return name + " " + email + " " + organization;
    }

    /*
       @RequestParam과 Map을 조합한 GET 메서드 구현
        - 값에 상관없이 요청을 받을 수 있음.
        - 예를 들어, 회원 가입 관련 API에서 사용자는 회원 가입을 하면서 ID 같은 필수 항목이 아닌 취미 같은 선택 항목에 대해서는 값을 기입하지 않는 경우가 있음.
          이러한 경우에는 매개변수의 항목이 일정하지 않을 수 있어 Map 객체로 받는 것이 효율적.
     */
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map ->{
            sb.append(map.getKey() + " : " + map.getKey() + "\n");
        });

        return sb.toString();
    }

    // DTO 객체를 활용한 GET 메서드 구현
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }

}
