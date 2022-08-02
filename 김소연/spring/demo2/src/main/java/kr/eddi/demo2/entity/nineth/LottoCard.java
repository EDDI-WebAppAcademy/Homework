package kr.eddi.demo2.entity.nineth;

import kr.eddi.demo2.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LottoCard {
    //실제 번호에 대한 할당은 여기서
    private int[] numbers;
    private final int LOTTO_NUMBER_LENGTH = 6;
    private final int BIAS = 1;
    private final int MIN = 0;
    private final int MAX = 99 + BIAS;



    public LottoCard(){
        numbers = new int[LOTTO_NUMBER_LENGTH];
    }
    //로또카드매니저가 관리하는 로또카드 만들어지게됨


    //번호를 부여하는 매커니즘 필요
    public int generateLottoNumber(int curIdx){
        int tmpNum = CustomRandom.makeIntCustomRandom(MIN,MAX);
        //중복을 허용하지 않는 랜덤할당 필요
        numbers[curIdx] = tmpNum;
        //로또 카드는 여러개있는데 혼자 있으니까 관리가 안돼
        //결국 외부 매니저 다시 데려와서 처리해야하는데.. 지저분해지는 단점
        //그러면 .. 어케 예쁘게 만들어줄것인가 생각 ㄱㄱ
        //로또 매니저가 개입하게 만드는게 베스트일듯..

        return tmpNum;
    }

}
