package kr.eddi.homework.entity.fifth;

import kr.eddi.homework.entity.utility.basic.third.CustomRandom;

import lombok.Getter;

@Getter
public class RandomChar {
    //지정된 범위
    //랜덤
    //체크 아니라면 다시 생성
    private int min;
    private int max;

    public RandomChar(int min, int max){
        this.min = min;
        this.max = max;
    }


    public String checkEngRandomChar(){
        int ranNum = CustomRandom.makeIntCustomRandom(min,max);
        if ((ranNum <= 90) || (97 <= ranNum)) {
            char ranChar = (char) ranNum;
            return "생성된 랜덤 문자 : " + ranChar;
        } else {
            char ranChar = (char) ranNum;
            return "랜덤 문자 : " + ranChar +"<br>" + "소문자나 대문자가 아닙니다. 다시 생성합니다"
                    +"<br>"+ checkEngRandomChar();
        }
    }
}
