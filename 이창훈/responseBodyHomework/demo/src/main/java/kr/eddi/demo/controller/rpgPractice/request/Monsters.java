package kr.eddi.demo.controller.rpgPractice.request;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Monsters {
    private Integer monsterId;
    private String name;
    private Integer hp;
    private Integer exp;
    private Integer dropMoney;
}
