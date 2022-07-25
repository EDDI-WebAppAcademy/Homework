package fourth.question4.q1_q4;

public class Cat {
    private static String[][] cats = {
            {"nabi", "1"},
            {"hoho", "2"}
    };

    public static void showcats() {
        for (int i = 0; i < cats.length; i++) {
            for (int j = 0; j < cats[i].length; j++) {
                System.out.println(cats[i][j]);
            }
        }

    }

    public static void main(String[] args) {
        showcats();
    }
}


//1. 2 by 2 이중 배열을 초기화해서 아무 값이나 넣어보세요.
//2. 1번 문제에서 초기화한 배열을 출력해봅시다.
//3. 고양이 클래스를 만들어주세요.
//4. 1번 문제를 클래스화 해봅시다.
