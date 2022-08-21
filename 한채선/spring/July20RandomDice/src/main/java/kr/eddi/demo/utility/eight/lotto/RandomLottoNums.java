package kr.eddi.demo.utility.eight.lotto;

import kr.eddi.demo.utility.fourth.RandomNumber;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
public class RandomLottoNums {

    private static final int RANDOM_LOTTO_MIN = 0;
    private static final int RANDOM_LOTTO_MAX = 99;
    private static final int RANDOM_LOTTO_LEAST = 1;
    private static final int LOTTO_SIZE = 6;


    /**
     * 로또를 위한 랜덤한 번호 생성기. 최소값과 최대값을 받아 범위 내의 정수를 생성해 돌려준다.
     * @param min 최소값
     * @param max 최대값
     * @return
     */
    public static int lottoNumMaker(int min, int max) {
        return RandomNumber.randomNum(min, max);
    }

    /**
     * 총 구매자를 입력 받아 구매자들의 로또 번호의 각각의 자리에 배정될 번호(0~99까지)를 생성하는 메서드.
     * 한 자리에 중복되는 숫자가 없게 생성한다.
     * @param buyersNum 구매자 수
     * @return 한 자리에 배정할 구매자 수 만큼의 번호 리스트
     */

    public static Set<Integer> lottoNumsListForEachIndex(int buyersNum) {
        Set<Integer> lottoNumsForEachIndexList = new HashSet<>(buyersNum);

        while (lottoNumsForEachIndexList.size() == buyersNum) {
            lottoNumsForEachIndexList.add(lottoNumMaker(RANDOM_LOTTO_MIN,RANDOM_LOTTO_MAX));
        }
        return lottoNumsForEachIndexList;

    }

    /**
     * 총 구매자의 수와 임의의 범위를 입력 받아 구매자들의 로또 번호의 각각의 자리에 배정될 번호를 생성하는 메서드.
     * 한 자리에 중복되는 숫자가 없게 생성한다.
     * @param buyersNum 구매자 수
     * @param min 로또 번호 범위의 최소값
     * @param max 로또 번호 범위의 최대값
     * @return 한 자리에 배정할 구매자 수 만큼의 번호 리스트
     */
    public static Set<Integer> lottoNumsListForEachIndex(int buyersNum, int min, int max) {
        Set<Integer> lottoNumsForEachIndexList = new HashSet<>(buyersNum);

        while (lottoNumsForEachIndexList.size() == buyersNum) {
            lottoNumsForEachIndexList.add(lottoNumMaker(min, max));
        }
        return lottoNumsForEachIndexList;
    }

}
