package kr.eddi.demo.entity.basic.twelveth;


import kr.eddi.demo.entity.basic.utility.basic.twelveth.UserInput;
import lombok.ToString;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ToString
public class Player {
    private List<Map<PockerCardShape, PockerCardCharacter>> cardsDeck;

    public Player() {                          // 플레이어 생성되면 그 사람이 가진 카드덱 생성됨
        cardsDeck = new ArrayList<>();
    }

    public void acquireNewCards(Map<PockerCardShape, PockerCardCharacter> newCardDeck) {  // 플레이어에게 카드덱을 연동해주는 메소드>
                                                                                          // 인자로 pokerCard.divideCard() 카드덱을 받아서 그걸 플레이어 개별 카드덱에 넣음
        //System.out.println("newCardDeck: " + newCardDeck);

        cardsDeck.add(newCardDeck);
    }

    public Map<PockerCardShape, PockerCardCharacter> publishingPlayersCard() {   // 콘솔에 출력되는 내용(유저 입력 받는 곳) - 4 -> 입력하여 오픈되는 카드덱을 반환
        System.out.println("현재 손패입니다");
        System.out.println(cardsDeck);                                     // acquireNewCards() 매소드를 통해 얻은 카드덱을 보여주고
        System.out.print("공개할 카드를 선택하세요: ");

        UserInput.inputIntKeyBoard();                             // UserInput 클래스의 inputIntKeyBoard() 메소드 호출 -> int 숫자(카드덱의 인덱스) 입력 받기
        return cardsDeck.get(UserInput.getSelectedNumber());      // UserInput 클래스의 selectedNumber 값(입력받은 값) 가져와서 cardsDeck 의 인덱스로 넣어서 리턴
    }
}