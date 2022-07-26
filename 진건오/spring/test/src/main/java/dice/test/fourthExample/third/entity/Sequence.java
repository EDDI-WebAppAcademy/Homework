package dice.test.fourthExample.third.entity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Sequence {

    private int startNum;
    private int finishNum;
    private int statusValToken;

    private final int EVENNum_TOKEN = 2;
    private final int MULTIPLE_3_TOKEN = 3;
    private final int MULTIPLE_4_TOKEN = 4;
    private final int MULTIPLE_RANDOM_NUM_TOKEN = 5;
    private final int RANDOM_NUM_CYCLE = 6;
    private final int CREATE_RANDOM_NUM_MOVEMENT = 7;

    private int MAX_RANGE = 100;

    public Sequence(int tokenNum, int startNum , int finishNum) {

        this.startNum = startNum;
        this.finishNum = finishNum;
        this.statusValToken = tokenNum;

    }

    //짝수 배수
    public String doMultipleNum(int startNum, int finishNum , int multipleNum) {
        String resultMsg = " ";

        for (int i = startNum; i <= finishNum; i++) {
            if (i % multipleNum == 0) {
                resultMsg += i +", ";
            }
        }
        return resultMsg;
    }

    public String doMultipleOf4Sum(int startNum, int finishNum, int multipleNum) {
        int totalSum = 0;

        for (int i = startNum; i <= finishNum; i++) {
            if (i % multipleNum == 0) {
                totalSum += i;
            }
        }
        return "배수의 총 합: " + totalSum;
    }

    public String doMultipleOfRandomNum(int startNum, int finishNum) {
        int MIN = 2;
        int MAX = 10;

        String resultMsg = " ";

        int createRandomNum = CreateRandom.makeToCreateRandom(MAX, MIN);

        for (int i = startNum; i <= finishNum; i++) {
            if (i % createRandomNum == 0) {
                resultMsg += i +", ";
            }
        }
        return resultMsg;
    }

    public String doRandomNumCycle(int startNum, int finishNum) {
        int MIN = 2;
        int MAX = 10;

        int sum = 0;
        int createRandomNum;

        createRandomNum = CreateRandom.makeToCreateRandom(MAX, MIN);

        for (int i = startNum; i <= finishNum ; i++) {
            if (i % createRandomNum == 0) {
                createRandomNum = CreateRandom.makeToCreateRandom(MAX, MIN);
                sum += i;
            }
        }
        return "생성된 모든 합: " + sum;

    }

    public String doRandomNumToMovement(int startNum, int finishNum) {
        int MIN = 2;
        int MAX = 10;

        int createRandomNum = 0;
        int sum = 0;

        for (int i = startNum; i <= finishNum ; i+=createRandomNum) {
            createRandomNum = CreateRandom.makeToCreateRandom(MAX, MIN);
            sum += createRandomNum;
        }
        return "생성된 숫자: " + createRandomNum +"<br> 생성된 숫자만큼 이동한 숫자의 총합: " + sum;
    }

    public String findAccordingToStatus(int tokenNum) {

        if (tokenNum == EVENNum_TOKEN) {
            log.info("짝수 배수");
            return doMultipleNum(startNum, finishNum, EVENNum_TOKEN);

        } else if (tokenNum == MULTIPLE_3_TOKEN) {
            log.info("3의 배수");
            return doMultipleNum(startNum, finishNum, MULTIPLE_3_TOKEN);

        } else if (tokenNum == MULTIPLE_4_TOKEN) {
            log.info("배수 덧셈");
            return doMultipleOf4Sum(startNum, finishNum, MULTIPLE_4_TOKEN);

        } else if (tokenNum == MULTIPLE_RANDOM_NUM_TOKEN) {
            log.info("난수를 통해 생성된 값의 배수");
           return doMultipleOfRandomNum(startNum, finishNum);

        } else if (tokenNum == RANDOM_NUM_CYCLE){
            log.info("난수를 생성하고 배수 출력 반복, 생성된 난수 합");
            return doRandomNumCycle(startNum, finishNum);

        } else if (tokenNum == CREATE_RANDOM_NUM_MOVEMENT) {
            return doRandomNumToMovement(startNum, finishNum);
        }

        return "잘못된 실행입니다.";
    }
}
