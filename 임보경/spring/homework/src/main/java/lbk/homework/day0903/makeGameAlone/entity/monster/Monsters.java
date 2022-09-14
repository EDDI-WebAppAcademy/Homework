package lbk.homework.day0903.makeGameAlone.entity.monster;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Monsters{

    private List<Object> monsterBook;

    public Monsters() {
        monsterBook = new ArrayList<>();

        AnimalType knoll = new AnimalType(
                1,
                "놀",
                200,
                10,
                10,
                20,
                40
        );

        AnimalType wildBoar = new AnimalType(
                2,
                "멧돼지",
                400,
                10,
                10,
                50,
                100
        );

        AnimalType orc = new AnimalType(
                3,
                "오크",
                550,
                10,
                10,
                40,
                150
        );

        AnimalType orge = new AnimalType(
                4,
                "오우거",
                1000,
                10,
                10,
                50,
                250
        );

        AnimalType wyvern = new AnimalType(
                5,
                "와이번",
                3500,
                10,
                10,
                150,
                500
        );

        AnimalType wereWolf = new AnimalType(
                6,
                "웨어울프",
                5000,
                10,
                10,
                700,
                1500
        );

        AnimalType minotaur = new AnimalType(
                7,
                "미노타우로스",
                10000,
                10,
                10,
                1000,
                1500
        );

        AnimalType drake = new AnimalType(
                8,
                "드레이크",
                20000,
                10,
                10,
                50000,
                5000
        );

        DevilType lordOfDeath = new DevilType(
                9,
                "죽음의 군주",
                1000000,
                500,
                500,
                1000000,
                2000000
        );

        monsterBook.add(knoll);
        monsterBook.add(wildBoar);
        monsterBook.add(orc);
        monsterBook.add(orge);
        monsterBook.add(wyvern);
        monsterBook.add(wereWolf);
        monsterBook.add(minotaur);
        monsterBook.add(drake);
        monsterBook.add(lordOfDeath);
    }



}
