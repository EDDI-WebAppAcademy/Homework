package javaBasic.question;

public class Q5PrintEvenNumber {
    public void q5Solve() {
        System.out.println("1 ~ 100까지 숫자중 짝수만 출력해보자.");
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
