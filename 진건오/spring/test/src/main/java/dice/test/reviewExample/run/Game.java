package dice.test.reviewExample.run;

import dice.test.reviewExample.entity.CharacterManager;
import dice.test.reviewExample.entity.Food;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {


    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        Food food = new Food();
        CharacterManager chm = new CharacterManager(food);

        runEatFoodCharacter(chm);
    }

    public static void runEatFoodCharacter(CharacterManager chm) throws IOException {
        System.out.println("플레이어 상태: " + chm);
        chm.viewTakeFoodList();
        System.out.println();

        System.out.print("무엇을 먹을까요? >");

        String answer = br.readLine();
        System.out.println(answer+" 을/를 입력하셨습니다.");

        chm.eatFood(answer);
        System.out.println("플레이어 상태: " + chm);
    }
}
