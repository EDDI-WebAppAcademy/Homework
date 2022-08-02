package kr.eddi.homework.entity.nineth;

import java.util.ArrayList;
import java.util.List;

public class LottoCardManager {
    private List<LottoCard> cards;
    private final int LOTTO_CARD_LENGTH = 6;
    private final int DUPLICATE_LIMITATION = 100; //제한인원에 맞춰

    public LottoCardManager(int playerNum) { //플레이어수 받고
        cards = new ArrayList<>(playerNum); //카드 리스트 객체화

        for (int i = 0; i < playerNum; i++) {
            cards.add(new LottoCard()); //로또카드 세트 불러와서 객체화, 카드에 추가
        }
    }

    public void allocLottoCardNumber(){
        int tmpNum;
        int people = cards.size();

        for (int j = 0; j < LOTTO_CARD_LENGTH; j++) { //6개
            for (int i = 0; i < people; i++) { //사람수
                if(people > DUPLICATE_LIMITATION) { //100명보다 많으면
                    cards.get(i).generateLottoNumber(j); //중복 신경 안쓰겠다.
                }else{
                    do{ //무조건 한번이상 실행 dowhile문
                        tmpNum = cards.get(i).generateLottoNumber(j); //실행
                    }while (verifyDuplicateLottoCard(i,j,cards)); //아니면 종료
                }
            }
        }
    }

    public void allocNonDuplicateLottoCardNumber(){
        int tmpNum;

        for (int j = 0; j < LOTTO_CARD_LENGTH; j++) {
            for (int i = 0; i < cards.size(); i++) { //사람수
                do{
                    tmpNum = cards.get(i).generateLottoNumber(j);
                }while(verifyDuplicateLottoCard(i,j,cards);
            }
        }
    }

    private Boolean verifyDuplicateLottoCard(int curPersonIdx, int curLottoColumnIdx, List<LottoCard> cards){

    }
}
