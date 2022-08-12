package dice.test.reviewExample.schoolBells.run;

import dice.test.reviewExample.schoolBells.entity.SyllableNames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SchoolBellsController {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String syllableNames = "";

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("종료하려면 숫자 0을 입력하세요");
            System.out.print("계이름의 숫자를 입력하세요>");

            int selectSyllableNames = Integer.parseInt(br.readLine());

            startSchoolBellsSong(selectSyllableNames);

            System.out.println("계이름 : ("+syllableNames+")");

            if (selectSyllableNames == 0) {
                break;
            }
        }
    }

    public static void startSchoolBellsSong(int selectSyllableNames) {
        if (selectSyllableNames == SyllableNames.DO.getValue()) {
            syllableNames += SyllableNames.DO.getName();

        } else if (selectSyllableNames == SyllableNames.RE.getValue()) {
            syllableNames += SyllableNames.RE.getName();

        } else if (selectSyllableNames == SyllableNames.MI.getValue()) {
            syllableNames += SyllableNames.MI.getName();

        } else if (selectSyllableNames == SyllableNames.FA.getValue()) {
            syllableNames += SyllableNames.FA.getName();

        } else if (selectSyllableNames == SyllableNames.SOL.getValue()) {
            syllableNames += SyllableNames.SOL.getName();

        } else if (selectSyllableNames == SyllableNames.RA.getValue()) {
            syllableNames += SyllableNames.RA.getName();

        } else if (selectSyllableNames == SyllableNames.SI.getValue()) {
            syllableNames += SyllableNames.SI.getName();
        }
    }
}
