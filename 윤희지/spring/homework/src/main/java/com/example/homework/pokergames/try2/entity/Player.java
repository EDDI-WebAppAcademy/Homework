package com.example.homework.pokergames.try2.entity;

import com.example.homework.pokergames.try1.entity.NicknameGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Setter
@Getter
@ToString

public class Player {
    private String name;
    private BigInteger wallet;
    private Map<String, Boolean> cards;
    // 받은 카드 정보를 보관한 적절한 데이터 타입의 변수

    public Player() {
        this.name = NicknameGenerator.generateRandomNickname();
        wallet = new BigInteger("100000000");
        cards = new HashMap<>();
    }

    public Player(String name) {
        this.name = name;
        wallet = new BigInteger("100000000");
        cards = new HashMap<>();
    }
    
    public void chooseOpenCard() {
        Scanner scanner = new Scanner(System.in);
        String openCard = "";

        while(true) {
            System.out.println("플레이어 " + this.name + "님, 오픈할 카드를 선택하세요.");
            System.out.println("보유카드: " + cards.toString());
            System.out.print("오픈할 카드: ");
            openCard = scanner.next();
            if(cards.containsKey(openCard)) {
                cards.put(openCard, true);
                break;
            } else {
                System.out.println("잘못된 카드 정보 입력.");
            }
        }
    }
}
