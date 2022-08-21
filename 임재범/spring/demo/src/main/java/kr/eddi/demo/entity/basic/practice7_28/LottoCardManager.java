package kr.eddi.demo.entity.basic.practice7_28;

import kr.eddi.demo.entity.basic.practice7_28.LottoCard;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class LottoCardManager {
    private List<LottoCard> cards; //LottoCard형 리스트 cards선언.
    private final int LOTTO_CARD_LENGTH = 6;
    private final int DUPLICATE_LIMITATION = 100;

    //LottoCardManager객체 생성시, cards(리스트)는 인자로 입력된 플레이어의수 만큼 공간을 할당받고, 그 공간에 각각 LottoCard객체를 생성합니다.
    public LottoCardManager(int playerNum) {
        cards = new ArrayList<>(playerNum);

        for (int i = 0; i < playerNum; i++) {
            cards.add(new LottoCard());
        }
    }

    //100번째 로또티켓 까지는 n번째 번호끼리 중복을 허용하지 않는 규칙이 적용되며, 101번째 티켓부터는 그 규칙없이 생성됨.
    //로또번호를 LottoCard클래스의 generateLottoNumber메서드를 이용해서 하나씩 생성함.
    // i는 몇번째 사람인지, j는 로또의 몇번째 번호인지를 의미.
    public void allocLottoCardNumber() {
        int tmpNum;
        int people = cards.size();

        for (int j = 0; j < LOTTO_CARD_LENGTH; j++) {
            for (int i = 0; i < people; i++) {
                if (people > DUPLICATE_LIMITATION) { cards.get(i).generateLottoNumber(j); }
                else {
                    do {
                        tmpNum = cards.get(i).generateLottoNumber(j);
                    } while (verifyDuplicateLottoCard(i, j, cards)); //중복이 있으면 다시 할당함.
                }
            }
        }
    }

    //이 메서드는 1~100번째 티켓까지 즉, n번째 번호가 중복되지 않도록하는 메서드.
    public void allocNonDuplicateLottoCardNumber() {
        int tmpNum;

        for (int j = 0; j < LOTTO_CARD_LENGTH; j++) {
            for (int i = 0; i < cards.size(); i++) {
                do {
                    tmpNum = cards.get(i).generateLottoNumber(j);
                } while (verifyDuplicateLottoCard(i, j, cards));
            }
        }
    }

    //이 메서드는 n번째 번호들끼리 중복이 있는지 확인하여 true/false를 리턴합니다.
    private Boolean verifyDuplicateLottoCard(
            int curPersonIdx, int curLottoColumnIdx, List<LottoCard> cards) {

        if (curPersonIdx == 0) { return false; } //0번째 사람 즉, 첫번째 사람만 있을 때는 당연히 중복은 없다.

        int compareTarget = cards.get(curPersonIdx).getNumbers()[curLottoColumnIdx]; //중복이 있는지 확인하려는 그 로또 번호.

        for (int i = 0; i < curPersonIdx; i++) {
            int eachNumber = cards.get(i).getNumbers()[curLottoColumnIdx];

            System.out.printf("curPersonIdx: %d, compareTarget: %d, eachNumber: %d\n",
                    curPersonIdx, compareTarget, eachNumber);

            if (eachNumber == compareTarget) {
                return true; //같은 번쨰에 있는 번호들을 순회하며, 같은게 있으면 중복이 있다고 true를 반환!
            }
        }

        return false;
    }

    //이 메서드는 101번째티켓부터 사용하는 메서드. 중복허용되는 구간이라 그냥 generateLottoNumber()하면됨.
    public void allocDuplicateLottoCardNumber() {
        int tmpNum;

        for (int j = 0; j < LOTTO_CARD_LENGTH; j++) {
            for (int i = 0; i < cards.size(); i++) {
                cards.get(i).generateLottoNumber(j);
            }
        }
    }
}
