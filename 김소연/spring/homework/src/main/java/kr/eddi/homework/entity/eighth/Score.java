package kr.eddi.homework.entity.eighth;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Score {
    private int resultScore;
    private List<Integer> lottoList;

    public void lottoScore(int lottoNum){
        lottoList = new ArrayList<>();
        lottoList.add(lottoNum);


        //(숫자1 + 숫자2 + 숫자3 + 숫자4) * 숫자5 ] / 숫자6
        int num1 = lottoList.get(0);
        int num2 = lottoList.get(1);
        int num3 = lottoList.get(2);
        int num4 = lottoList.get(3);
        int num5 = lottoList.get(4);
        int num6 = lottoList.get(5);


        resultScore = ((num1 + num2 + num3 + num4) *num5)/num6;
    }
}
