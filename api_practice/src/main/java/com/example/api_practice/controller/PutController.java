package com.example.api_practice.controller;

import com.example.api_practice.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*
    <PutController>
    - 웹 어플리케이션 서버를 통해 데이터베이스 같은 저장소에 존재하는 리소스 값을 업데이트 하는 데 사용함.
    - POST API와 비교하면 요청을 받아 실제 데이터베이스에 반영하는 과정(서베스 로직)에서 차이가 있지만 컨트롤러 클래스를 구현하는 방법은 POST API와 거의 동일함.
        -> 리소스를 서버에 전달하기 위해 HTTP Body를 활용해야 하기 때문.
 */
@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    /*
       @RequestBody와 Map을 활용한 PUT 메서드 구현
        - PUT API는 POST 메서드와 마찬가지로 값을 HTTP Body에 담아 전달함.
        - 서버에서는 이 값을 받기 위해 @RequestBody를 사용함.
     */
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData){
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    /*
       DTO 객체를 활용한 PUT 메서드 구현 - String
        - Response -> Content-Type : text/plain
     */
    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }

    /*
       DTO 객체를 활용한 PUT 메서드 구현 - MemberDto
        - Response -> Content-Type : application/json
     */
    @PutMapping(value = "/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto){
        return memberDto;
    }

    /*
       ResponseEntity를 활용한 PUT 메서드 구현
        - RequestEntity와 ResponseEntity는 HttpEntity를 상속받아 구현한 클래스.
        - ResponseEntity : 서버에 들어온 요청에 대해 응답 데이터를 구성해서 전달할 수 있게 함.
        - ResponseEntity는 HttpEntity로부터 HttpHeaders와 Body를 가지고 자체적으로 HttpStatus를 구현함.
     */
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);
    }

}
