package dice.test.fourthExample.sixth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MultipleOf3 {
    private static int[] mpArr = new int[33];
    private static final int MAX = 100;

    public static int[] multipleOf3Check() {

        int mpArrCnt = 0;

        for (int i = 1; i <= MAX; i++) {
            if (i % 3 == 0) {
                mpArr[mpArrCnt] = i;
                mpArrCnt++;
            }
        }
        return mpArr;
    }

    @ResponseBody
    @GetMapping("sixth-test")
    public  int[] multipleOf3View() {
        return multipleOf3Check();
    }
}


