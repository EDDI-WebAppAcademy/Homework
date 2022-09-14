package com.example.homework.pokergames.try2.entity;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//player와 관련된..일들을 하겠지?
@Getter
@ToString

public class PlayerManager {
    //PlayerManager니까 Player 정보를 여기서 관리하는 게 맞지?
    private List<Player> players;
    private int playerNum;
    List<String> nicknameList = new ArrayList<>();

    public PlayerManager(int playerNum) {
        players = new ArrayList<>();
        for (int i = 0; i < playerNum; i++) {
            players.add(new Player(makeCustomNickname()));
        }
        this.playerNum = playerNum;
    }

    public void openPlayerCard() {
        for (int i = 0; i < this.playerNum; i++) {
            players.get(i).chooseOpenCard();
        }
    }

    //사용자 입력을 받는 닉네임 메이커
    public String makeCustomNickname() {
        String customNickname = "";
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.print("닉네임을 입력하세요: ");
            customNickname = input.next();
            if (verifyDup(customNickname)) {
                System.out.println("중복되는 닉네임입니다. 새로운 닉네임을 입력하세요.");
            } else {
                nicknameList.add(customNickname);
                System.out.println("닉네임 생성 완료");
                break;
            }
        }
        return customNickname;
    }

    private boolean verifyDup(String customNickname) {
        for (int i = 0; i < nicknameList.size(); i++) {
            if (nicknameList.size() == 0) {
                return false;
            } else if(nicknameList.get(i).equals(customNickname)) {
                return true;
            }
        }
        return false;
    }

}
