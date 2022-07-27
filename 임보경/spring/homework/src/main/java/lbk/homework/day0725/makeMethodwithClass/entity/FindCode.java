package lbk.homework.day0725.makeMethodwithClass.entity;

import lbk.homework.day0725.makeMethodwithClass.utility.RandomUtility;

public class FindCode {
    private static final int MIN = 65;
    private static final int MAX = 122;
    private static RandomUtility random = new RandomUtility();

    public String judgeCodeOrNot() {
        while (true) {
            int ranNum = random.randomNumber(MAX, MIN);
            String regExp = "^[a-zA-Z]*$";
            String result = changeToString(ranNum);

            if (result.matches(regExp)) {
                return result;
            } else {
                return "아직 안나왔습니다. 다시 시도해주세요.";
            }
        }
    }
    public static String changeToString(int ranNum) {
        char ch = (char)ranNum;
        return String.valueOf(ch);
    }
}
