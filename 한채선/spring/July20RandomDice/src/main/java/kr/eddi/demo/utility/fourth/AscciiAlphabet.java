package kr.eddi.demo.utility.fourth;

public class AscciiAlphabet {

    // 65~90 까지 대문자
    // 97~122 까지 소문자


    private final int ASCII_ALP_MIN = 65;
    private final int ASCII_ALP_MAX = 122;
    private final int ASCII_CHAR_MIN = 33;
    private final int ASCII_CHAR_MAX = 126;



    /**
     * 랜덤한 소문자와 대문자 알파벳을 출력하는 메소드
     * @return char 알파벳
     */
    public char randomAlphabet() {
        char resultABC;
        while (true) {
            int asciiNumber = CustomRandomNumber.randomNum(ASCII_ALP_MIN, ASCII_ALP_MAX);
            if (asciiNumber > 91 && asciiNumber < 96) {
                continue;
            } else {
                resultABC = (char) asciiNumber;
                break;
            }
        }
        return resultABC;
    }


    /**
     * 아스키 코드 범위 내의 랜덤한 character를 출력하는 메소드
     * @return char 문자 or 알파벳
     */
    public char randomASCIIChar() {
        char asciiChar = (char) CustomRandomNumber.randomNum(ASCII_CHAR_MIN, ASCII_CHAR_MAX);
        return asciiChar;
    }
}



