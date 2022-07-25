package kr.eddi.demo.entity.basic.fourth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Q2_FIBONACCI {
    public int fibo() {
        int count = 0;
        int num = 20;
        System.out.print("수열의" + num + "번째 항 : " + count(num));

        if (num <= 1) {
            return num;
        } else {
            return count(num - 1) + count(num - 2);
        }
    }
}