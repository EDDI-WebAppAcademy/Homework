package kr.eddi.demo.entity.basic.augusttwelve;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Player {
    private final int DEFAULT_HP = 30;
    private int hp = DEFAULT_HP;

    private int atk = 10;
    private int def = 13;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void sethp(int plusHP){
        this.hp += plusHP;
    }

    public void setAtk(int plusAtk){
        this.atk += plusAtk;
    }

    public void setDef(int plusDef){
        this.def += plusDef;
    }
}