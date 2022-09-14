package dice.test.fifthExample.first.entity;

import dice.test.fifthExample.third.entity.CreateRandom;

public class DecimalAsciiConversion {
    private final int randomDecimal;
    private final int MAX = 122;
    private final int MIN = 65;

    public DecimalAsciiConversion(int randomDecimal) {
        this.randomDecimal = randomDecimal;
    }

    public String checkAsciiConversion() {

        if (randomDecimal >= 65 && randomDecimal <= 90) {
            return changeUpperCase(randomDecimal);
        } else if (randomDecimal >= 97 && randomDecimal <=122) {
            return changeLowerCase(randomDecimal);
        } else if ((!(randomDecimal >= 65 && randomDecimal <= 90)) || (!(randomDecimal >= 97 && randomDecimal <=122))) {
            return remainderAscii();
        }
        return "실행";
    }

    public String changeUpperCase(int rd) {
        int max = 90;
        int min = 65;

        String chAscii = Character.toString(rd);

        return "생성된 아스키코드: " + chAscii;
    }

    public String changeLowerCase(int rd) {
        int max = 122;
        int min = 97;

        String chAscii = Character.toString(rd);

        return "생성된 아스키코드: " + chAscii;
    }

    public String remainderAscii() {
        final int max2 = 90;
        final int min2 = 65;
        final int max1 = 122;
        final int min1 = 97;

        int randomDecimal = CreateRandom.remakeToCreateRandom(max1, min1, max2, min2);
        String beforeChangeAscii = Character.toString(this.randomDecimal);

        String chAscii = Character.toString(randomDecimal);

        return "생성된 아스키코드: " + beforeChangeAscii +" 이므로 다시 생성합니다.<br>다시 생성된 아스키코드: " + chAscii;
    }
}
