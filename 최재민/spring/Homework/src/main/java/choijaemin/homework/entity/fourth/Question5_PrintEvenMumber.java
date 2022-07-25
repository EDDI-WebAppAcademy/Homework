package choijaemin.homework.entity.fourth;



import choijaemin.homework.utility.fourth.FindTimesNum;


public class Question5_PrintEvenMumber {
    private final int CHOICENUM = 2;
    private String ShowNum ="";

    public String EvenNum(){
        return FindTimesNum.TimesNums(CHOICENUM,ShowNum);
    }
}
