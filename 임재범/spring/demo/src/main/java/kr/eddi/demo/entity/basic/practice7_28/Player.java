package kr.eddi.demo.entity.basic.practice7_28;

import kr.eddi.demo.entity.basic.practice7_28.LottoCard;
import kr.eddi.demo.entity.basic.practice7_28.LottoCardManager;
import kr.eddi.demo.utility.basic.practice7_28.NicknameGenerator;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Player {
    private LottoCard card; //플레이어는 LOttoCard를 갖습니다. 이 LottoCard 안에는 로또번호를 적을 int형 배열이 담겨있습니다.
    private String nickName;//닉네임.

    //Player객체 생성하면 NicknameGenerator에 의해 랜덤닉네임이 중복되지 않게 생성됩니다.
    public Player() {
        nickName = NicknameGenerator.generateRandomNickname();
    }


    //LottoCardManager는 LottoCard들을 관리 할 수 있습니다. 이 메서드를 통해 미리 생성해둔, 6개번호가 부여된 로또를 플레이어에게 전달합니다.
    public void acquireLottoCard(LottoCardManager manager, int idx) {
        card = manager.getCards().get(idx);
    }
}
