package dice.test.seventh.trySeventhExample.entity;

import dice.test.seventh.trySeventhExample.utillity.Lotto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserScore {

    private int totalScore;

    public void calcLottoNum(int[] lottoArr, int MAX_USERS) {
        int sum = 0;

        for (int i = 0; i < MAX_USERS; i++) {
            if (lottoArr[i] == lottoArr[0]) {
                totalScore += lottoArr[i];

            } else if (lottoArr[i] == lottoArr[1]) {
                totalScore += lottoArr[i];

            } else if (lottoArr[i] == lottoArr[2]) {
                totalScore += lottoArr[i];

            } else if (lottoArr[i] == lottoArr[3]) {
                totalScore += lottoArr[i];

            } else if (lottoArr[i] == lottoArr[4]) {
                if (lottoArr[i] == 0) {
                    int newLottoNumInd4 = Lotto.newLottoNum();
                    lottoArr[i] = newLottoNumInd4;
                    totalScore = totalScore * lottoArr[i];
                }
                totalScore = totalScore * lottoArr[i];

            } else if (lottoArr[i] == lottoArr[5]) {
                if (lottoArr[i] == 0) {
                    int newLottoNumIdx5 = Lotto.newLottoNum();
                    lottoArr[i] = newLottoNumIdx5;
                    totalScore = totalScore / lottoArr[i];
                }
                totalScore = totalScore / lottoArr[i];
            }
        }
    }
}
