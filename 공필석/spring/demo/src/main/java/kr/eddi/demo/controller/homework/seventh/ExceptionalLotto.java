package kr.eddi.demo.controller.homework.seventh;

import java.util.Random;

public class ExceptionalLotto {
    public static void main(String[] args) {

        Random ran = new Random();

        int lotto[] = new int[6];
        int lottoNum[] = new int[46];
        int personSum = 3; // 참가자 수 설정
        final int MAX_PERSON = 100; //최대 참가자 수 설정
        final int MIN_PERSON = 1;


        System.out.println("========추첨결과 확인========\n");

        for (int p = 1 ; p <= personSum ; p++) {
            System.out.print( p + "번 참가자 ");
            for (int i = 0; i < lotto.length; i++) {
                lotto[i] = ran.nextInt(100) ;
            }
            
            // 6개의 로또번호 추첨하여 숫자크기와 관계 없이 출력.
            for (int i = 0; i < lotto.length; i++) {
                // 1의 자리 숫자 추첨 시 표기를 명확히 하기 위헤 앞에 0을 붙인다.
                if (lotto[i] < 10) {
                    System.out.print("0" + lotto[i] + " ");
                } else {
                    System.out.print(lotto[i] + " ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("==========추첨완료===========");
    }

}