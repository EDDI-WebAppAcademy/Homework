package lbk.homework.day0903.makeGameAlone.entity.player;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Status {
    private int level = 1;
    private Integer hp = 50;
    private Integer mp = 30;
    private int defaultAtk = 10;
    private int atkAdded = 0;
    // atk 하단처럼 하라면 장비 적용해도 변화없음.. 이유 아직 모름.
    private int atk;
    private Integer money = 500000000;
    private Integer currentExpBar = 0;
    private Integer totalExpBar = 0;

    private int str = 10;
    private int intelligence = 10;
    private int dex = 10;
    private int def = 10;
    private int vit = 10;

    Status () {
        this.atk = atkAdded + defaultAtk;
    }
}
