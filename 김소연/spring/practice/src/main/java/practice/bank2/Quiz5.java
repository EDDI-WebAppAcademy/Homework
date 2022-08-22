package practice.bank2;

public class Quiz5 {
    //1 ~ 100까지 숫자중 짝수만 출력해보자.
    public static void main(String[] args) {
        even();
    }

    public static void even(){
        for (int i = 1; i <= 100 ; i++) {
            if(i % 2 == 0){
                System.out.print(i+" ");
            }
        }
    }
}
