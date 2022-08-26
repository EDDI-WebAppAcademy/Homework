package dice.test.seventh.seventhCodeReview.utillity;

import dice.test.fifthExample.third.entity.CreateRandom;

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

    private static List<String> nickNames = new ArrayList<>();

    public static String generateRandomNickname() {
        String tmpNickname;
        int nickNameLength = CreateRandom.makeToCreateRandom(NICKNAME_MAX, NICKNAME_MIN);

        do {
            tmpNickname = generateCustomLengthRandomNickname(nickNameLength);
        } while (verifyNickname(tmpNickname));

        nickNames.add(tmpNickname);

        return tmpNickname;
    }

    public static Boolean verifyNickname(String nickname) {
        if (nickNames.size() == 0) {
            return false;
        }

        for (int i = 0; i < nickNames.size(); i++) {
            if (nickNames.get(i).equals(nickname)) {
                return true;
            }
        }
        return false;
    }

    public static String generateCustomLengthRandomNickname(int nickNameLength) {
        String tmpNickname = "";
        char singleChar = 0;
        int upperLowerDecision;

        for (int i = 0; i < nickNameLength; i++) {
            upperLowerDecision = CreateRandom.makeToCreateRandom(UPPER_LOWER_MAX, UPPER_LOWER_MIN);

            if (upperLowerDecision % UPPER_LOWER_DICISION_FACTOR == UPPERCASE) {
                singleChar = (char) (CreateRandom.makeToCreateRandom(UPPER_CHAR_END, UPPER_CHAR_START));
            } else if (upperLowerDecision % UPPER_LOWER_DICISION_FACTOR == LOWERCASE) {
                singleChar = (char) (CreateRandom.makeToCreateRandom(LOWER_CHAR_END, LOWER_CHAR_START));
            }
            tmpNickname += singleChar;
        }
        return tmpNickname;
    }
}
