package kr.eddi.demo.entity.homework.fourth;

import java.util.Random;

public class NumberChangeAscii {

    private int start;
    private int end;
    private int randomNumber;
    private char valueChar;

    public NumberChangeAscii(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public char printRandomNumberChangeAscii() {
        Random random = new Random();
        while(true) {
            randomNumber = random.nextInt(end - start) + start;
            if (65 <= randomNumber && randomNumber <= 90) {
                return valueChar = (char) randomNumber;
            } else if (97 <= randomNumber && randomNumber <= 122) {
                return valueChar = (char) randomNumber;
            } else {
                continue;
            }
        }
    }
}
