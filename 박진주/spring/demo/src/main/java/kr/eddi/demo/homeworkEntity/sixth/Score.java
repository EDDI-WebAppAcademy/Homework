package kr.eddi.demo.homeworkEntity.sixth;

//게임 점수 기록

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Score {

    public int[] playerNum;
    public int[] score1 = {0,0,0,0,0}; // 초기값 점수

    public int[] totalScore = new int [5];  //주사위게임 후 total 점수

    public int[] scoreplayerNum = new int[5];


}
