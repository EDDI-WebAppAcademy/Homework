package com.example.homework.javapractice.total;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter

public class TotalPractice {
    //1. 게임 아이템 중 음식 클래스 내부에 사과, 귤, 포도, 빵 등을 구현해봅시다.
    //음식들을 먹으면 어떤 음식을 먹었냐에 따라서 각기 다른 능력이 발휘됨
    //(이건 각자 하고 싶은대로 hp를 회복시키던 공격력을 올리던 등등) <-- 캐릭터 클래스가 하나 필요하긴함.\
    // 이중해쉬(0) , for문으로 객체 다루기(0), 인터페이스(0), 리스트(0), 클래스 간 정보연동()
    // 잠깐...이중..해쉬...를 굳이 굳이 써야한다면..어디다가 쓰는 게 가장 나을까..?!!
    // 플레이어 인벤토리를..이렇게 관리해야 하나..?Map<Player, List<Map<String, Integer>>>

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Map<String, Integer> foods = new HashMap<>();
        Map<Player, Map<String, Integer>> playerEatStatus = new HashMap<>();

        foods.put("사과", 10);
        foods.put("포도", 20);
        foods.put("라면", 30);
        foods.put("떡볶이",40);

        final int PLAYER_NUM = 4;

        for (int i = 0; i < PLAYER_NUM; i++) {
            players.add(new Player());
            players.get(i).name = "Player" + (i + 1);
            System.out.println(players.get(i).name);
        }
    }
}

class Player implements EatFood{
    public String name;
    public int hp;
    public int mp;

    public Player() {
        this.hp = 100;
        this.mp = 100;
    }

    @Override
    public void changeStatus(String foodType, Map<String, Integer> foods) {
        hp -= foods.get(foodType);
        mp += foods.get(foodType);
    }
}

class Food {
    public String name;
    public int score;

    public Food(String name, int score) {
        this.name = name;
        this.score = score;
    }
}


