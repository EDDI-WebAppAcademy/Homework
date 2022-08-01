package kr.eddi.demo.entity.basic.practice7_28;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

//이렇게 하면 로또번호가 6개인 상황에서만 사용할 수 있는 재사용성 낮은 코드가 됨.
@Getter
@Setter
public class LottoTicket {

    final int NUMOFLOTTO = 6;
    int[] lottoNum = new int[NUMOFLOTTO]; //로또번호가 담길 공간.

    //로또번호 n개가 담긴 인트형 배열 하나를 뱉음.
    public int[] makeLottoTicket(){



        return new int[]{0};
    }



        }




