package fourth.question4.q5_q10;

import java.util.Scanner;

class Student {
    public static String name;
    public static final String[] subject ={"수학", "영어", "국어"};


    // 이름 입력 받는 메소드
    public static void inputName() {
        Scanner sc = new Scanner(System.in);

        System.out.println("이름을 입력해주세요 : ");
        name = sc.nextLine();
    }

}


//5. 학생 클래스를 만들어봅시다.
//6. 학생 클래스에 수학, 영어, 국어 점수를 입력 받도록 개조합니다.
//7. 학생 클래스의 평균을 계산해봅시다.
//9. 7번 문제에서 분산을 구해봅시다.
//10. 7번 문제에서 표준 편차를 구해봅시다.
//[출처] 문제 은행 [ 4 ] (에디로봇아카데미) | 작성자 링크쌤