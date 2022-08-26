package dice.test.fifthExample.fourth.entity;

public class TimesTableProcess {
    private final int inputNum;

    public TimesTableProcess(int inputNum) {
        this.inputNum = inputNum;
    }

    public String exceptionCircumstance(int timeTableVal) {

        if (timeTableVal <= 1) {
            return "실행할 수 없는 구구단 입니다.";
        }
        return null;
    }

    public String doTimeTable(int timeTableVal) {
        final int startVal = 1;
        final int endVal = 10;
        String str = " ";

        for (int i = startVal; i < endVal; i++) {
            str += timeTableVal + "*" + i + "=" + (timeTableVal * i) + "<br>";
        }
        return str;
    }

    public String findTimetableProcess(int timeTableVal) {
        final int endRange = 0;

        if (timeTableVal > endRange) {
            return doTimeTable(timeTableVal);
        } else if (timeTableVal <= endRange) {
            return exceptionCircumstance(timeTableVal);
        }

        return null;
    }
}
