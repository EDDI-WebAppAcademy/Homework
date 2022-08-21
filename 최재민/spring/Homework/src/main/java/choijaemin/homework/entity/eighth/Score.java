package choijaemin.homework.entity.eighth;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Score {
    private List<Integer> lotteryNum = new ArrayList();;
    private int TotalScore;
    public void addlotteryNum(int ramNum){
        lotteryNum.add(ramNum);

    }

}
