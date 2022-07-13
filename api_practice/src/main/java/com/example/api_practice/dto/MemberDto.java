package com.example.api_practice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
    <DTO 클래스>
    - DTO 클래스에 선언된 필드는 컨트롤러의 메서드에서 쿼리 파라미터의 키와 매핑된다.
    - 쿼리스트링의 키가 정해져 있지만 받아야 할 파라미터가 많을 경우에는 DTO 객체를 활용해 코드의 가독성을 높일 수 있다.
 */
@Getter
@Setter
@ToString
public class MemberDto {

    private String name;
    private String email;
    private String organization;

}
