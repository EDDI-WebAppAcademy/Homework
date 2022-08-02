package choijaemin.homework.utility.eighth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrawLottoNum {
    private static final int MAX = 99;
    private static final int MIN = 0;

    private static int drawCnt = 6;
    public static int makeLottoNum(){return CreateRandomNum.CreateLottoNum(MAX , MIN);}

    public static int setDrawCnt(){
        return drawCnt;
    }

    public static int setDrawCnt(int drawCnt1){
        return drawCnt = drawCnt1;
    }

}
