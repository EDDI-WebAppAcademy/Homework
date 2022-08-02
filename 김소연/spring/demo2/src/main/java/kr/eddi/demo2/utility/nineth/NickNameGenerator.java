package kr.eddi.demo2.utility.nineth;

import kr.eddi.demo2.utility.basic.third.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class NickNameGenerator {
    //랜덤 닉네임 생성
    //관리 차원이 들어가서 막상 보니까 유틸리티가 좀 애매하네
    //그래도 db요소는 아니니까 유틸리티에 놓고 쓰자

    private static final int UPPER_LOWER_MIN = 0;
    private static final int UPPER_LOWER_MAX = 2;
    private static final int NICKNAME_MIN = 5; //닉네임 최소 5글짜
    private static final int NICKNAME_MAX = 10;
    private static final int ALPHABET_LENGTH = 26;
    private static final int UPPER_CHAR_START = 65;
    private static final int UPPER_CHAR_END = UPPER_CHAR_START + ALPHABET_LENGTH;

    private static final int LOWER_CHAR_START = 97;
    private static final int LOWER_CHAR_END = LOWER_CHAR_START + ALPHABET_LENGTH;

    private static final int UPPER_LOWER_DECISION_FACTOR = 2;
    private static final int LOWERCASE = 1;
    private static final int UPPERCASE = 0;

    private static List<String> nickNames = new ArrayList<>(); //닉네임 쓰라해 리스트

    public static String generateRandomNicknames(){//요청을 하면 쳐내야지

        String tmpNickname;
        int nickNameLength = CustomRandom.makeIntCustomRandom(
                NICKNAME_MIN,NICKNAME_MAX);//닉네임 길이 가변적 배치할 수 있도록함

        do {
            tmpNickname = generateCustomLengthRandomNickname(nickNameLength);
            //이게 적합한지 검증 필요
        } while(verifyNickname(tmpNickname));

        nickNames.add(tmpNickname);
        return tmpNickname;
    }

    public static Boolean verifyNickname(String nickname){
        if(nickNames.size() == 0){ return false; } //아무것도 없음 재껴라
        for (int i = 0; i < nickNames.size(); i++) {
            //사이즈만큼 돌면서 같은게 있는지
            if(nickNames.get(i).equals(nickname)){ //같으면 0이 나오지?
                return true;
            }
        }
        return false;
    }

    public static String generateCustomLengthRandomNickname(int nickNameLength){
        //특정한 길이값 전달할 수 있게
        String tmpNickname = "";
        char singleChar = 0;
        int upperLowerDecision;

        for (int i = 0; i < nickNameLength; i++) {
            upperLowerDecision = CustomRandom.makeIntCustomRandom(
                    UPPER_LOWER_MIN,UPPER_LOWER_MAX);//0 1 둘중 하나 루프돌며 처리
            //대소문자 처리 했으면 실제 숫자값주기

            if(upperLowerDecision % UPPER_LOWER_DECISION_FACTOR == UPPERCASE){
                singleChar = (char) CustomRandom.makeIntCustomRandom(
                        UPPER_CHAR_START,UPPER_CHAR_END);
            }else if (upperLowerDecision % UPPER_LOWER_DECISION_FACTOR == LOWERCASE){
                singleChar = (char) CustomRandom.makeIntCustomRandom(
                        LOWER_CHAR_START,LOWER_CHAR_END);
            }
            tmpNickname += singleChar;
        }
        return tmpNickname;
    }

}
