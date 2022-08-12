package dice.test.reviewExample.schoolBells.run;

import dice.test.reviewExample.schoolBells.entity.SelectSyllableNames;
import dice.test.reviewExample.schoolBells.entity.SyllableNames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SchoolBellsController {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String syllableNames = "";
    private static SelectSyllableNames ssn;
    private static int selectSyllableNames;

    public static void main(String[] args) throws IOException {
        ssn = new SelectSyllableNames();
        System.out.println("계이름: 도(1), 레(2), 미(3), 파(4), 솔(5), 라(6), 시(7)");
        System.out.println("종료하려면 숫자 0을 입력하세요");
        System.out.println();

        while (true) {
            System.out.print("계이름의 숫자를 입력하세요>");

            selectSyllableNames = Integer.parseInt(br.readLine());

            syllableNames = ssn.startSchoolBellsSong(selectSyllableNames);

            if (selectSyllableNames == 0) {
                break;
            } else if (selectSyllableNames < 0 || selectSyllableNames > 7){
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
                System.out.print("계이름의 해당하는 숫자를 입력하세요>");
                selectSyllableNames = Integer.parseInt(br.readLine());
            }
        }
        System.out.println("계이름 : (" + syllableNames + ")");
    }
}
