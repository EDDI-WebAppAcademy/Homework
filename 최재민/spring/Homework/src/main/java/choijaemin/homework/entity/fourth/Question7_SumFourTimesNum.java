package choijaemin.homework.entity.fourth;

public class Question7_SumFourTimesNum {
    private int SumFourTimesNum;

    public int FourTimesNum(){
        for (int i = 0; i < 101; i++) {
            if (i% 4 == 0){
                this.SumFourTimesNum += i;
            }
        }
        return this.SumFourTimesNum;
    }
}
