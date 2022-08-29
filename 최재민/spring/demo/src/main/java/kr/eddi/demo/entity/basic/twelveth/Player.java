package kr.eddi.demo.entity.basic.twelveth;
import kr.eddi.demo.utility.basic.twelveth.UserInput;
import lombok.Getter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ToString
@Getter
public class Player {
    private List<Map<PockerCardShape, PockerCardCharacter>> cardsDeck;
    private PockerCard pockerCard;
    private int currentRound = 0;
    private int firstCardDividedCnt = 3;
    public Player() {
        cardsDeck = new ArrayList<>();
    }

    public List<Map<PockerCardShape, PockerCardCharacter>> acquireNewCards() {

        pockerCard = new PockerCard();
        pockerCard.shuffle();
        if (currentRound == 0 ){
            for (int i = 0; i < firstCardDividedCnt; i++) {
                cardsDeck.add(pockerCard.divideCard());
            }
            //System.out.println("첫 번째로 나누어준 패 cardsDeck: " + cardsDeck.toString());
        }else {
            Map<PockerCardShape, PockerCardCharacter> newDividedCard = pockerCard.divideCard();
            cardsDeck.add(newDividedCard);
            System.out.println("나누어준 패 newDividedCard: " + newDividedCard);
            System.out.println("전채 패 : " + cardsDeck.toString());
        }


        this.currentRound++;

        return cardsDeck;
    }

    public Map<PockerCardShape, PockerCardCharacter> publishingPlayersCard() {
        if (currentRound == 1 ){
            System.out.println("현재 손패입니다");
            System.out.println(cardsDeck);
            System.out.print("공개할 카드를 선택하세요: ");
            UserInput.inputIntKeyBoard();
            return cardsDeck.get(UserInput.getSelectedNumber());
        }
        return null;
    }
}