package kr.eddi.demo.entity.basic.fourth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Q3_PROGRESSION {
    public static void main(String[] args) {
        int num = 25;
        System.out.print("수열의" + num + "번째 항 : " + count(num));
    }

    public static int count (int num) {
        if (num <= 3) {
            return 1;
        } else {
            return count(num - 1) + count(num - 3);
        }
    }
}