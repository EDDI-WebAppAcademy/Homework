import java.util.Scanner;

public class Practice {

    public static void main(String[] args) {
        System.out.println("==== 이름과 나이 확인하기 ====");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("이름을 입력하세요 : ");
            String name = sc.next();

            if (name.equals("김가람")) {
                System.out.print("나이를 입력하세요 : ");
                int age = sc.nextInt();
                if (age == 29) {
                    System.out.printf("이름은 %s 이고, 나이는 %d 입니다", name, age);
                    break;
                } else {
                    System.out.println("다시 확인하세요.");
                    continue;
                }
            } else {
                System.out.println("잘못된 이름입니다.");
                continue;
            }
        }
    }
}
