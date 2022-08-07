package kr.eddi.demo.homeworkEntity.seventh_fix;

import kr.eddi.demo.homeworkEntity.utility.basic.seventh_fix.LottoNum1;
import kr.eddi.demo.homeworkEntity.utility.basic.seventh_fix.RandomNickname;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Setter
@ToString
@Slf4j
@AllArgsConstructor
public class LottoPlayer1 {

    private LottoNum1 lottoNum1;

    private String nickName;


    public LottoPlayer1() {
        // log.info("로또플레이어가 생성됩니다");
        nickName = RandomNickname.makeNickname();

    }


    public void acquireLottoNums(LottoNumManager1 lottoNumManager1, int i) {

        lottoNum1 = lottoNumManager1.lottoNum1.get(i);

    }

}
