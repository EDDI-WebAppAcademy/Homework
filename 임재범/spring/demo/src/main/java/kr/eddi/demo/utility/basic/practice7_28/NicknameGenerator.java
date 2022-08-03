package kr.eddi.demo.utility.basic.practice7_28;

import kr.eddi.demo.utility.basic.third.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class NicknameGenerator {
    private static final int UPPER_LOWER_MIN = 0;
    private static final int UPPER_LOWER_MAX = 2;
    private static final int NICKNAME_MIN = 5;
    private static final int NICKNAME_MAX = 10;
    private static final int ALPHABET_LENGTH = 26;
    private static final int UPPER_CHAR_START = 65;
    private static final int UPPER_CHAR_END = UPPER_CHAR_START + ALPHABET_LENGTH;

    private static final int LOWER_CHAR_START = 97;
    private static final int LOWER_CHAR_END = LOWER_CHAR_START + ALPHABET_LENGTH;

    private static final int UPPER_LOWER_DICISION_FACTOR = 2;
    private static final int LOWERCASE = 1;
    private static final int UPPERCASE = 0;

    private static List<String> nickNames = new ArrayList<>(); //플레이어의 닉네임들이 담길 어레이리스트 nickNames

    //닉네임의 길이는 5~9자이고, generateCustomLengthRandomNickname()를 이용해서 닉네임을 생성하여 nickNames에 add합니다.
    public static String generateRandomNickname() {
        String tmpNickname;
        int nickNameLength = CustomRandom.makeIntCustomRandom(
                NICKNAME_MIN, NICKNAME_MAX);

        do {
            tmpNickname = generateCustomLengthRandomNickname(nickNameLength);
        } while(verifyNickname(tmpNickname));

        nickNames.add(tmpNickname);

        return tmpNickname;
    }

    //닉네임의 중복을 체크합니다. 이 중복체크 메서드는 정말 유용해보인다. 꼭 닉네임이 아니더라도 조금 수정해서 재사용가능해보임
    public static Boolean verifyNickname(String nickname) {
        if (nickNames.size() == 0) { return false; } //아직 저장된 닉네임이 없다면 중복은 당연히 없기에 false리턴.

        for (int i = 0; i < nickNames.size(); i++) {
            if (nickNames.get(i).equals(nickname)) {
                return true;
            }
        }

        return false;
    }

    //닉네임 만드는 규칙
    public static String generateCustomLengthRandomNickname(int nickNameLength) {
        String tmpNickname = "";
        char singleChar = 0;
        int upperLowerDecision;

        //닉네임의 각 문자가 대문자일지 소문자일지 랜덤하게 결정.
        for (int i = 0; i < nickNameLength; i++) {
            upperLowerDecision = CustomRandom.makeIntCustomRandom(
                    UPPER_LOWER_MIN, UPPER_LOWER_MAX);


            if (upperLowerDecision % UPPER_LOWER_DICISION_FACTOR == UPPERCASE) {
                singleChar = (char) CustomRandom.makeIntCustomRandom(
                        UPPER_CHAR_START, UPPER_CHAR_END);//대문자로 결정되었다면, singleChar에 대문자를 랜덤하게 아스키코드를 이용해서 생성한후 대입.
            } else if (upperLowerDecision % UPPER_LOWER_DICISION_FACTOR == LOWERCASE) {
                singleChar = (char) CustomRandom.makeIntCustomRandom(
                        LOWER_CHAR_START, LOWER_CHAR_END);//소문자로 결정되었다면 singleChar에 소문자를 랜덤하게 아스키코드를 이용해서 생성한 후 대입.
            }

            tmpNickname += singleChar; //문자를 이와같이 한개씩 생성하며 누산하는 방식으로 이루어짐.
        }

        return tmpNickname; //완성된 닉네임 리턴.
    }
}
