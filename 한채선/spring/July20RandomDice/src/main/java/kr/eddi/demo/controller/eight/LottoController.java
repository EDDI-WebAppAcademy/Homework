package kr.eddi.demo.controller.eight;

import kr.eddi.demo.entity.eight.LottoBuyer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@Slf4j
@RestController
@RequestMapping("/eighth")
public class LottoController {

    private final int LOTTO_BUYERS = 100;
    private LottoBuyer lottoBuyer;
    private LinkedHashMap<String, LottoBuyer> buyers;
    private String nickName;

    @GetMapping("/who-is-lotto-winner")
    public String whoIsLottoWinner() {

        return null;
    }

    public void startLotto(int buyersNum) {
        buyers = new LinkedHashMap<>(buyersNum);
        for (int i = 0; i < buyersNum; i++) {
            nickName = (i + 1) + "번 참가자";
            buyers.put(nickName, lottoBuyer = new LottoBuyer());
            lottoBuyer.setName(nickName);
        }
    }

}
