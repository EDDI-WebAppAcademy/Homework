package lbk.homework.day0903.makeGameAlone.entity.item;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Items {

    private List<Object> itemBooks ;


    public Items() {
        itemBooks = new ArrayList<>();

        Potions potion1 = new Potions(
                "초보자용 포션",
                100,
                50,
                "초보자용 포션 : HP 50 증가 "
        );
        Potions potion2 = new Potions(
                "중급 포션",
                200,
                150,
                "중급자를 위한 포션 : HP 150 증가 "
        );
        Potions potion3 = new Potions(
                "고급 포션",
                500,
                450,
                "초보자용 포션 : HP 450 증가 "
        );

        Swords sword1 = new Swords(
                "낡은 검",
                5000,
                100,
                "낡은 검 : 무기 공격력 100"
        );
        Swords sword2 = new Swords(
                "강철 검",
                50000,
                500,
                "강철로 만든 검 : 무기 공격력 300"
        );
        Swords sword3 = new Swords(
                "군주의 검",
                5000000,
                1000,
                "군주가 사용하는 검 : 무기 공격력 1000"
        );

        itemBooks.add(potion1);
        itemBooks.add(potion2);
        itemBooks.add(potion3);
        itemBooks.add(sword1);
        itemBooks.add(sword2);
        itemBooks.add(sword3);
    }

}
