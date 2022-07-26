package kr.eddi.demo.entity.basic.practice2;
import lombok.*;

@Getter
@Setter
public class TimeTable {
    int[][] arr = new int[9][3]; //구구단을 담으려면 9행3열짜리 행렬이 필요하다.

    //생성자.
    public TimeTable(int num){
        //전달 받은 숫자 num에 해당하는 구구단을 배열 arr에 담는역할.
        for(int i=0; i<9; i++){
            arr[i][0] = num;
            arr[i][1] = i+1;
            arr[i][2] = num*(i+1);
        } //arr에 입력된상태 이제 출력이 문제임.
    }


}
