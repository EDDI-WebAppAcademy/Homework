package kr.eddi.demo2.entity.nineth;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class LottoCardManager {
    //플레이어에 대해서 알 필요가 있을까 없을까..
    //위치값은 알아야하지..
    // 로또카드 불러오고.. 카드
    // 로또 카드를 관리하는 역할 수행
    private List<LottoCard> cards;
    private final int LOTTO_CARD_LENGTH = 6;
    private final int DUPLICATE_LIMITATION = 100;

    public LottoCardManager(int playerNum){ //플레이어 넘버값 받게 구성
        cards = new ArrayList<>(playerNum); //플레이어 넘버만큼 주고..

        for (int i = 0; i < LOTTO_CARD_LENGTH; i++) {
            cards.add(new LottoCard());
        }
    }

    //중복되는 말든 알아서하세요 메소드도 만들어봄
    //이거 넘어가면 중복 되는 말든~
    public void allocLottoCardNumber(){
        int tmpNum;
        int people = cards.size();

        for (int j = 0; j < LOTTO_CARD_LENGTH; j++) {
            for (int i = 0; i < cards.size(); i++) {
                if(people > DUPLICATE_LIMITATION){ cards.get(i).generateLottoNumber(j); }
                else{
                    do {
                        tmpNum = cards.get(i).generateLottoNumber(j);
                    } while (verifyDuplicateLottoCard(i, j, cards));
                }
            }
        }
    }


    public void allocNonLottoCardNumber(){
        int tmpNum;

        for (int j = 0; j < LOTTO_CARD_LENGTH; j++) {
            for (int i = 0; i < cards.size(); i++) {
                do {
                    cards.get(i).generateLottoNumber(j);
                } while (verifyDuplicateLottoCard(i, j, cards));
            }
        }
    }

    public Boolean verifyDuplicateLottoCard(
            int curPersonIdx, int curLottoColumnIdx, List<LottoCard> cards){
        if(curPersonIdx == 0){ return false; } //첫사람 오면 재껴

        //다음사람 오면 그 사람의의 번호 얻어서

       int compareTarget = cards.get(curPersonIdx).getNumbers()[curLottoColumnIdx];

        for (int i = 0; i < curPersonIdx; i++) { //현재 인덱스까지만 순회 자기자신제외 나머지 애들은 본다
            int eachNumber = cards.get(i).getNumbers()[curLottoColumnIdx];

            System.out.printf("curPersonIdx: %d, compareTarget: %d, eachNumber: %d\n",
                    curPersonIdx, compareTarget, eachNumber);

            if(eachNumber == compareTarget){
                return true;
            }
        }
        return false;
    }



    //중복 처리
    public void alloccDuplicateLottoCardNumber() {
        int tmpNum;

        for (int j = 0; j < LOTTO_CARD_LENGTH; j++) {
            for (int i = 0; i < cards.size(); i++) {
                cards.get(i).generateLottoNumber(j);
            }
        }
    }
}
