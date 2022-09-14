package kr.eddi.demo.homework.entity.fifith;

import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor // 선언한 변수에 대해 자동으로 생성자 만들어줌 . 즉 , public void Gugudan(num){this.num = num;}
public class Gugudan {
    private int num;

    public String makeGugudan(){

        String msg = "";
        int[] gugudan = new int[9];

        for (int i = 0; i < gugudan.length ; i++) {
            gugudan[i] = num *(i+1);
            msg += num + "*" + (i+1)+ "=" +gugudan[i] + "<br>";

        }

        return msg;
    }

}
