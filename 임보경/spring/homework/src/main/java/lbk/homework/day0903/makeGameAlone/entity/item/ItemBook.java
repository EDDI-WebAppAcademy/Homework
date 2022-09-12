package lbk.homework.day0903.makeGameAlone.entity.item;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ItemBook {

    private List<Item> itemBooks ;


    public ItemBook() {
        itemBooks = new ArrayList<>();

        Item potion1 = new Item(
                1,
                "초급 포션",
                100,
                50,
                "HP 50 회복 ",
                "포션"
        );
        Item potion2 = new Item(
                2,
                "중급 포션",
                400,
                250,
                "HP 250 증가 ",
                "포션"
        );
        Item potion3 = new Item(
                3,
                "고급 포션",
                1100,
                500,
                "HP 500 증가 ",
                "포션"
        );
        Item sword1 = new Item(
                4,
                "낡은 검",
                50000,
                100,
                "공격력 100 증가",
                "무기"
        );
        Item sword2 = new Item(
                5,
                "검",
                500000,
                200,
                "공격력 200 증가",
                "무기"
        );
        Item sword3 = new Item(
                6,
                "강철 검",
                5000000,
                400,
                "공격력 400 증가",
                "무기"
        );

        itemBooks.add(potion1);
        itemBooks.add(potion2);
        itemBooks.add(potion3);
        itemBooks.add(sword1);
        itemBooks.add(sword2);
        itemBooks.add(sword3);
    }

}
