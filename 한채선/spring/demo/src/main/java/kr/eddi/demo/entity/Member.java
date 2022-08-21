package kr.eddi.demo.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

/* @Getter, @Setter: Lombok 에서 제공하는 자동화 기능
   클래스 내부에 선언된 변수들에 대한 getter setter 메소드를 자동으로 생성
 */

public class Member {
    private String userName = "eddi";
    private String password = "456123";
}
