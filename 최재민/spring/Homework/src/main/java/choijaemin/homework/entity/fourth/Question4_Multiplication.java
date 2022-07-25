package choijaemin.homework.entity.fourth;

import java.util.Arrays;

public class Question4_Multiplication {
    private final int SEVENDAN = 7;
    private String[] showGUguDan = new String[9];
    public String sevenDan(){
        for (int i = 0; i < 9; i++) {
            showGUguDan[i] = String.format( SEVENDAN + "X" + (i+1) + "=" + SEVENDAN*(i+1) );
        }

        return Arrays.toString(showGUguDan);
    }
}
