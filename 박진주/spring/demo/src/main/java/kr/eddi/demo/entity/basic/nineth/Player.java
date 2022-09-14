package kr.eddi.demo.entity.basic.nineth;


import kr.eddi.demo.entity.basic.utility.basic.nineth.NicknameGenerator;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Player {      // 플레이어 역할 : 플레이어 생성 -> 닉네임 할당 + 플레이어의 카드 정보
    private LottoCard card;
    private String nickName;

    public Player() {
        nickName = NicknameGenerator.generateRandomNickname();
    }  // player 객체 생성하면 닉네임 할당됨

    public void acquireLottoCard(LottoCardManager manager, int idx) {

        card = manager.getCards().get(idx);          // 카드에 로또매니저- getcards 값을 넣어 로또 카드를 얻음 / idx 뭐지
    }
}