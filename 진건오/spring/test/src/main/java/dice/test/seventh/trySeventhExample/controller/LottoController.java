package dice.test.seventh.trySeventhExample.controller;

import dice.test.seventh.trySeventhExample.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LottoController {
    private static User user;
    private static int participant = 3;
    private static long PRIZE_MONEY = 10000000000l;


    @ResponseBody
    @GetMapping("seventh-lotto-process")
    public String displayLotto() {
        return totalView();
    }

    public static String createNickName() {
        return user.getUserNickName();
    }

    public static int totalUserLottoScore() {
        return user.getUserScore().getTotalScore();
    }

    public static String takeLottoNums() {
        user = new User();
        return user.takeLottoNum();
    }

    public static int findWinner(int[] userTotalLottoNum) {
        int highScoreUser = 0;

        for (int i = 0; i < userTotalLottoNum.length; i++) {
            if (userTotalLottoNum[i] > highScoreUser) {
                highScoreUser = userTotalLottoNum[i];
            }
        }
        return highScoreUser;
    }

    public static String winnerUser(int[] usersTotalLottoNum) {
        return "우승자의 점수는 [" + findWinner(usersTotalLottoNum) + "] 입니다.";
    }

    public String totalView() {
        user = new User();
        String msg = "";

        int[] usersTotalLottoNum = new int[participant];
        for (int i = 0; i < participant; i++) {
            msg += ("사용자 닉네임 : [" + createNickName() + "] <br>로또 번호: " + takeLottoNums() + ": 총 합:[" + totalUserLottoScore() + "]<br>" +
                    "=====================================<br>");
            usersTotalLottoNum[i] = user.getUserScore().getTotalScore();

        }
        return msg + winnerUser(usersTotalLottoNum);
    }
}
