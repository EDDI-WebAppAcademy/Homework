package dice.test.seventh.trySeventhExample.entity;


import dice.test.seventh.trySeventhExample.utillity.CreateUserNickname;
import dice.test.seventh.trySeventhExample.utillity.Lotto;
import lombok.Getter;

import java.util.Arrays;

@Getter
public class User {

    private UserScore userScore;
    private String userNickName;

    private static int LOTTO_MAX_RANGE = 6;
    private static int MAX_USERS = 6;

    public User() {
        this.userNickName = settingUserNickName();
        userScore = new UserScore();

    }

    // 로또번호 출력
    public String takeLottoNum() {
        int[] lottoArr = new int[LOTTO_MAX_RANGE];
        int sum = 0;

        for (int i = 0; i < LOTTO_MAX_RANGE; i++) {
            lottoArr[i] = Lotto.lottoNum();

            for (int j = 0; j < i; j++) {
                if (lottoArr[i] == lottoArr[j]) {
                    i--;
                }
            }
        }
        userScore.calcLottoNum(lottoArr, MAX_USERS);

        return Arrays.toString(lottoArr);

    }

    public String settingUserNickName() {
        return CreateUserNickname.takeUserNickName();
    }

}
