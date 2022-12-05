package kr.eddi.demo.entity.basic.eight;

import kr.eddi.demo.entity.Buyer;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LottoBuyer implements Buyer {

    private String name;
    List<Integer> lottoNums;

    public LottoBuyer() {
        lottoNums = new ArrayList<>();
    }
}
