package dice.test.seventh.seventhCodeReview.entity;

import dice.test.seventh.seventhCodeReview.utillity.NicknameGenerator;
import lombok.Getter;

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
