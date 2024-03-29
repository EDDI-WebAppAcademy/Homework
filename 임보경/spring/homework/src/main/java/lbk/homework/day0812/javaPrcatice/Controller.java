package lbk.homework.day0812.javaPrcatice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;


@RestController
@RequestMapping("day0811")
public class Controller {

    private GameCharacter gameCharacter;
    private Scanner scanner;

    @GetMapping("start")
    public String play() {

        gameCharacter = new GameCharacter();
        scanner = new Scanner(System.in);

        System.out.println("튜토리얼 중");
        System.out.println("전투중 상처를 입었습니다. 아이템을 먹어 회복하세요.");
        System.out.println("현재 HP : " + gameCharacter.getHp());

        gameCharacter.getFood().viewMyItem();

        System.out.println();
        System.out.print("먹을 아이템을 선택해주세요. : ");
        String itemName = scanner.next();
        gameCharacter.recovery(gameCharacter.getFood().eat(itemName));
        System.out.println("현재 HP : " + gameCharacter.getHp());

        return "진행중";
    }


}
