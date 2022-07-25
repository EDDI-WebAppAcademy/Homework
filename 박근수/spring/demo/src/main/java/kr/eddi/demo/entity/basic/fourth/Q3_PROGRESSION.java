package kr.eddi.demo.entity.basic.fourth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Q3_PROGRESSION {
    public int multideep() {
        int
        int num = 25;
        System.out.print("수열의" + num + "번째 항 : " + count(num));

        if (num <= 3) {
            return 1;
        } else {
            return count(num - 1) + count(num - 3);
        }
    }
}