package kr.eddi.demo.entity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
//클래스 내부의 멤버변수들에 대하여 알아서 게터 세터 만들어줌.
//실제 게터 세터 메소드를 만들줄도 알아야함.
public class Member {

    private String userName = "eddi";
    private String password = "456123";

}
