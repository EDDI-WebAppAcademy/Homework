package lbk.homework.day0812.javaPrcatice;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameCharacter {

    private Food food;
    private int hp = 130;
    private int max_hp = 200;


    public GameCharacter() {
        food = new Food();
    }

    public void recovery(int point) {
        int currentHp = getHp();
        if (currentHp + point < max_hp) {
            setHp(currentHp + point);
            System.out.println(point + "포인트 회복되었습니다.");
        } else if (currentHp + point >= max_hp) {
            setHp(max_hp);
            System.out.println("hp가 모두 회복되었습니다.");
        }
    }
}
