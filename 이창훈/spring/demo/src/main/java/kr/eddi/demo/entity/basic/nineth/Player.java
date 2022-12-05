package kr.eddi.demo.entity.basic.nineth;

import kr.eddi.demo.utility.basic.nineth.NicknameGenerator;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Player {
    private LottoCard card;
    private String nickName;

    public Player() {
        nickName = NicknameGenerator.generateRandomNickname();

    }
    public void acquireLottoCard(LottoCardManager manager, int idx) {
        card = manager.getCards().get(idx);
    }
}
