package kr.eddi.demo.entity.basic.practice7_28;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class LottoTicket {
    final int NUMOFLOTTO = 6;
    int[] LottoNum = new int[NUMOFLOTTO]; //6개의 로또번호
    private int finalScore; //최종점수

    public void finalScoreCal(int[] LottoNum){
        int sum=0;
        int multiplier = LottoNum[LottoNum.length-2];//곱하는 수는 마지막에서 두번째
        int divisor = LottoNum[LottoNum.length-1]; //나누는 수는 마지막 친구

        for(int i=0; i<LottoNum.length-2; i++){
            sum+=LottoNum[i];
        }

        this.finalScore = sum*multiplier/divisor; //최종결과를 finalScore에 저장.

    }





        }




