package kr.eddi.demo.controller.eight;

import kr.eddi.demo.entity.eight.LottoBuyer;
import kr.eddi.demo.utility.eight.lotto.RandomLottoNums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/eighth")
public class LottoController {

    private final int LOTTO_BUYERS_MAX = 100;

    private final int RANDOM_LOTTO_MAX = 99;
    private final int EXCEPT_ZERO_INDEXS = 2;
    private LottoBuyer lottoBuyer;
    private List<LottoBuyer> buyersList;



    private final long TOTAL_PRIZE_MONEY = 10000000000L;

    @GetMapping("/who-is-lotto-winner")
    public String whoIsLottoWinner() {
        buyLotto(LOTTO_BUYERS_MAX);

        return null;
    }

    /**
     * 로또 구매자의 수를 받아 각각의 로또 번호를 담을 빈 공간을 생성합니다.
     * 또한 로또 구매자에게 참가자 번호(별명)을 부여합니다.
     * @param buyersNum 총 구매자 수
     */

    public void buyLotto(int buyersNum) {
        buyersList = new ArrayList<>();
        for (int i = 0; i < buyersNum; i++) {
            String nickName = (i + 1) + "번 참가자";
            buyersList.add(lottoBuyer = new LottoBuyer());
            buyersList.get(i).setName((i+1) + "번 참가자");
        }
    }

    /**
     * 구매자들의 빈 로또 번호 리스트의 지정한 인덱스로 로또 번호를 배당합니다.
     * @param indexNum 번호를 지정할 인덱스 리스트
     */

    public void assignLottoNums(int indexNum) {
       Iterator<Integer> numsForEachList = RandomLottoNums.lottoNumsListForEachIndex(buyersList.size()).iterator();
       while (numsForEachList.hasNext()){
            for (int i = 0; i < buyersList.size(); i++) {
                buyersList.get(i).getLottoNums().add(indexNum,numsForEachList.next());
            }
        }
    }

    /**
     * 구매자들의 빈 로또 번호 리스트의 지정한 인덱스로 로또 번호를 배당합니다.
     *
     * @param indexNum
     * @param exceptIndexCounts
     */

    public void assignLottoNumsExceptZero(int indexNum, int exceptIndexCounts) {
        Iterator<Integer> numsForEachList = RandomLottoNums.lottoNumsListForEachIndex(buyersList.size(), 1, RANDOM_LOTTO_MAX).iterator();
        while (numsForEachList.hasNext()){
            for (int i = indexNum; i < buyersList.size(); i++) {
                buyersList.get(i).getLottoNums().add(indexNum,numsForEachList.next());
            }
        }
    }


    public void makeLotto(int totalIndex){
        for (int i = 0; i < totalIndex - EXCEPT_ZERO_INDEXS ; i++) {
            assignLottoNums(i);
        }
        for (int i = 0; i < EXCEPT_ZERO_INDEXS; i++) {


        }
    }
}
