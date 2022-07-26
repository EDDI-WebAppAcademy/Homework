package fourth.question2.q4;
import java.util.Scanner;

public class Gugudan {

   // public static void main(String[] args) {

    public static void makeGugudan(){
        Scanner sc = new Scanner(System.in);
        System.out.println("출력하고 싶은 구구단 숫자를 입력해주세요: ");
        int num = sc.nextInt();


        int[] gugudan = new int[9];

        for (int i = 0; i < gugudan.length ; i++) {
            gugudan[i] = num *(i+1);
            System.out.println(num + "*" + (i+1)+ "=" +gugudan[i]);
        }
    }

    }

//}

//구구단 7단을 출력해보자!
//[출처] 문제 은행 [ 2 ] (에디로봇아카데미) | 작성자 링크쌤