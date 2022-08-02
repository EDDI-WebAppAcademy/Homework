package kr.eddi.demo2.entity.nineth;

import kr.eddi.demo2.utility.nineth.NickNameGenerator;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Player {
    //사용자가 액션을 취해 로또 카드 정보 획득

    //플레이어는 로또 카드를 가지고 있을거고..
    //닉네임도 있을거야
    LottoCard card;
    String nickName;

    //백명의 사람 이름 만들긴 어려우니까 nickNameGenerator쓸거
    //여기저기서 많잉 쓸수 있으니까 유틸리티로 뺼게

    //닉네임 제너레이터 완성했으니 플레이어가 할당하게 해야지
    public Player(){
        nickName = NickNameGenerator.generateRandomNicknames();
    }
    //플레이어가 사용자 정보를 받았고
    //또 할게 있나? 점수 계산은 얘한테 시키면 안됨

    //바뀌든 말든 관심 ㄴㄴ
    public void acquireLottoCard(LottoCardManager manager, int idx){
        card = manager.getCards().get(idx);
    }
}
