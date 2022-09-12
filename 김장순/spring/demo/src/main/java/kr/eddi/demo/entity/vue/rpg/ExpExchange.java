package kr.eddi.demo.entity.vue.rpg;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ExpExchange {
    private String name;

    public ExpExchange(String name){
        this.name = name;
    }
}
