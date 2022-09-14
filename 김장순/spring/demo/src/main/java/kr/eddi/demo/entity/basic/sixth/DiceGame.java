package kr.eddi.demo.entity.basic.sixth;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DiceGame {
    private final int MIN = 1;
    private final int MAX = 6;
    private int participants;
    private final List<Integer> sumArr = new ArrayList<>(participants);

    public DiceGame(int participants) {

        this.participants = participants;
    }

    public List<Integer> firstRoll(List<Integer> sumArr) {

        for (int i = 0; i < participants; i++) {
            sumArr.add(CustomRandom.makeIntCustomRandom(MIN, MAX));
        }
        return sumArr;
    }

    public List<Integer> secondRoll(List<Integer> sumArr) {

        int throwSum = 0;
        for (int i = 0; i < sumArr.size(); i++) {
            if (sumArr.get(i) % 2 == 0) {
                int secondNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
                if (secondNum == 1) {
                    sumArr.set(i, sumArr.get(i) + 1);
                    for (int j = 0; j < sumArr.size(); j++) {
                        if (sumArr.get(j) >= 2) {
                            sumArr.set(j, sumArr.get(j) - 2);
                        } else if (sumArr.get(j) == 1) { //2점 미만일 때는 1점만 감점
                            sumArr.set(j, sumArr.get(j) - 1);
                        }
                    }
                } else if (secondNum == 3) {
                    sumArr.set(i, sumArr.get(i) + 3);
                    for (int j = 0; j < sumArr.size(); j++) {
                        if (j != i) {
                            if (sumArr.get(j) >= 3) { //3점 이상인 친구에게만 3점씩 가져오기
                                sumArr.set(j, sumArr.get(j) - 3);
                                throwSum += 3;
                            }
                        }
                    }
                    sumArr.set(i, sumArr.get(i) + throwSum);
                } else if (secondNum == 4) {
                    sumArr.set(i, sumArr.get(i) + 4);
                    break;
                } else if (secondNum == 5) {
                    sumArr.set(i, sumArr.get(i) + (5 - 2)); //2씩 나누어 주어야함, 한번만 모두에게 나누어줌
                    for (int j = 0; j < sumArr.size(); j++) {
                        if (j != i) {
                            sumArr.set(j, sumArr.get(j) + 2);
                        }
                    }

                } else {
                    sumArr.set(i,sumArr.get(i)+secondNum);
                }
            } else {

            }
        }
        return sumArr;
    }
}
