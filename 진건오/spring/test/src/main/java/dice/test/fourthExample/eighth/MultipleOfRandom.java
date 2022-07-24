package dice.test.fourthExample.eighth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Slf4j
@Controller
public class MultipleOfRandom {

    private static final int MAX = 100;
    private static final int RANDOM_PICK_NUM_MAX = 10;
    private static final int RANDOM_PICK_NUM_MIN = 2;
    private static Random random;

    public static int multipleOfRandomPick() {
        random = new Random();
        int pickNum = random.nextInt(RANDOM_PICK_NUM_MAX - RANDOM_PICK_NUM_MIN) + RANDOM_PICK_NUM_MIN;

        log.info("랜덤메소드를 이용한 배수선택 실행");

        return pickNum;
    }

    public static int[] doMultipleRandomNum() {
        int cntNum = 0;

        int randomPick = multipleOfRandomPick();
        int mpArrCnt = (MAX/ randomPick);

        int[] mpArr = new int[mpArrCnt];

        for (int i = 1; i <= MAX; i++) {

            if (i % randomPick == 0) {

                mpArr[cntNum] = i;
                cntNum++;

            }
        }
        return mpArr;
    }

    @ResponseBody
    @GetMapping("/eighth-test")
    public int[] multipleOfRandomView() {
        return doMultipleRandomNum();
    }
}
