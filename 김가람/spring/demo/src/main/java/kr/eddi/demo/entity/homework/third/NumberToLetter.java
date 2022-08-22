package kr.eddi.demo.entity.homework.third;

import kr.eddi.demo.entity.basic.fourth.NumberLoop;
import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NumberToLetter {
    private int start;
    private int end;

    public String letterCheckLoop() {
        String msg = "";
        while (true) {
            int ranNum = CustomRandom.makeIntCustomRandom(start, end);
            char ch = (char) ranNum;
            if (Character.isLowerCase(ch) || Character.isUpperCase(ch)) {
                msg += "출력된 문자는 " + ch + "입니다.";
                break;
            } else {
                msg += "소문자도 대문자도 아니므로 숫자를 다시 뽑습니다.<br>";
                continue;
            }
        }
        return msg;
    }
}
