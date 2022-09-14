package kr.eddi.demo.entity.homework.thirteen;


import kr.eddi.demo.utility.basic.third.CustomRandom;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.*;

public class Fruit {
    private Map<String, List<Integer>> fruits;

    private List<Integer> fruitsAbility = new ArrayList<>();

    private final int MIN = 0;
    private final int MAX = 3;


    public void setFruitsAbility() {
        fruits = new HashMap<>();

        fruitsAbility.add(5);
        fruitsAbility.add(10);
        fruitsAbility.add(15);
        fruitsAbility.add(20);

        fruits.put("사과", fruitsAbility);
        fruits.put("레몬", fruitsAbility);
        fruits.put("바나나", fruitsAbility);
        fruits.put("두리안", fruitsAbility);
    }

    public String chooseFruits() { //유틸리티로 빼야 할거 같지만 그냥 하자...
        Scanner sc = new Scanner(System.in);

        Object[] keys = fruits.keySet().toArray();
        Object randomKey = keys[new Random().nextInt(keys.length)];

        System.out.println("4가지 과일상자 중 하나를 골라주세요 (1~4의 숫자중 입력 가능)");
        System.out.println("               ㅁ ㅁ ㅁ ㅁ");

        int scanNum = sc.nextInt();

        switch (scanNum) {
            case 1:
                return "1번 상자를 골라 " + randomKey + " 등장!\n" +
                        showEffect((String) randomKey);
            case 2:
                return "2번 상자를 골라 " + randomKey + " 등장!\n" +
                        showEffect((String) randomKey);
            case 3:
                return "3번 상자를 골라 " + randomKey + " 등장!\n" +
                        showEffect((String) randomKey);
            case 4:
                return "4번 상자를 골라 " + randomKey + " 등장!\n" +
                        showEffect((String) randomKey);
            default:
                return "숫자를 다시 입력해주세요.";
        }
    }

    public int getAmount() {
        int ranNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
        int effect = fruits.get("사과").get(ranNum); //수치만 랜덤으로 얻으면 되기에 키값 아무거나 가능
        return effect;
    }

    public String showEffect(String randomKey) {
        Character character = new Character();
        switch (randomKey) {
            case "사과":
                return "HP가 " + getAmount() + " 회복됩니다.";
            case "레몬":
                return "MP가 " + getAmount() + " 회복됩니다.";
            case "바나나":
                return "경험치가 " + getAmount() + " 증가합니다.";
            case "두리안":
                return "HP가 " + getAmount() + " 감소합니다.";
            default:
                return "";
        }
    }

}






