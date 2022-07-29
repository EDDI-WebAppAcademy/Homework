package dice.test.seventh.trySeventhExample.utillity;

import dice.test.fifthExample.third.entity.CreateRandom;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;


public class CreateUserNickname {

    private static int ASCII_MAX_RANGE = 90;
    private static int ASCII_MIN_RANGE = 65;

    private static int MAX_USERS_RANGE = 6;

    public static String takeUserNickName() {
        int asciiCode = CreateRandom.makeToCreateRandom(ASCII_MAX_RANGE, ASCII_MIN_RANGE);
        String changeCodeName = Character.toString(asciiCode);

        return changeCodeName;
    }

//    public static void main(String[] args) {
//        for (int i = 0; i < MAX_USERS_RANGE; i++) {
//            System.out.println(takeUserNickName());
//        }
//
//    }
}
