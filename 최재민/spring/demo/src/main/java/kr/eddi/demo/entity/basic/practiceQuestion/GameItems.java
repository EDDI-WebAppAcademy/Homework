package kr.eddi.demo.entity.basic.practiceQuestion;

import kr.eddi.demo.utility.practiceQuestion.DisposableItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameItems implements DisposableItems {

    private List<UseItemList> DisposableItems;

    public void items(){
        DisposableItems = new ArrayList<>();
        for (UseItemList UseItemList : UseItemList.values()){
            DisposableItems.add(UseItemList);
        }
    }

    @Override
    public void useDisposableItems(Player player, String UseItem) {
        int PlayerMaxHp = player.getCharacterMAXHp();
        int PlayerMaxMp = player.getCharacterMAXHp();
        int PlayerHp;
        int PlayerMp;
        int PlayerAttack;
        int PlayerDefensive;
        switch (UseItem){
            case "사과" :
                System.out.println("체력을"+ 30 +"회복합니다.");
                PlayerHp = player.getCharacterCurrentHp();
                PlayerHp += 30;

                if(PlayerHp > PlayerMaxHp){
                    PlayerHp = PlayerMaxHp;
                }

                player.setCharacterCurrentHp(PlayerHp);

                break;

            case "귤" :
                System.out.println("마나를"+ 10 +"회복합니다.");
                PlayerMp = player.getCharacterCurrentMP();
                PlayerMp += 10;

                if(PlayerMp > PlayerMaxMp){
                    PlayerMp = PlayerMaxMp;
                }

                player.setCharacterAttack(PlayerMp);
                break;

            case "썩은 사과" :
                System.out.println("체력을 " + 7 +"회복합니다.");
                System.out.println("썩은 사과를 먹어 배탈이 납니다. 방어력 1 감소");
                PlayerHp = player.getCharacterCurrentHp();
                PlayerHp += 7;

                if(PlayerHp > PlayerMaxHp){
                    PlayerHp = PlayerMaxHp;
                }

                player.setCharacterCurrentHp(PlayerHp);

                PlayerDefensive = player.getCharacterDefensive();
                PlayerDefensive -= 1;
                player.setCharacterDefensive(PlayerDefensive);
                break;

            case "포도" :
                System.out.println("공격력이 "+ 2 +"증가합니다.");
                PlayerAttack = player.getCharacterAttack();
                PlayerAttack += 2;
                player.setCharacterAttack(PlayerAttack);
                break;
            case "빵":
                System.out.println("최대체력이 5증가 합니다.");
                PlayerMaxHp +=5;
                player.setCharacterMAXHp(PlayerMaxHp);

            case "우유":
                System.out.println("최대 마나가 2 증가합니다. ");
                PlayerMaxMp +=2;
                player.setCharacterMAXMP(PlayerMaxMp);

            case "황금사과":
                System.out.println("모든 체력과 마나를 회복하고 모든 능력치가 5만큼 증가합니다.");
                player.setCharacterCurrentMP(PlayerMaxHp);
                player.setCharacterCurrentMP(PlayerMaxMp);

                PlayerAttack = player.getCharacterAttack();
                PlayerAttack += 5;
                player.setCharacterAttack(PlayerAttack);

                PlayerDefensive = player.getCharacterDefensive();
                PlayerDefensive += 5;
                player.setCharacterDefensive(PlayerDefensive);
                break;
        }
    }
}
