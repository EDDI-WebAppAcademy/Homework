package choijaemin.homework.entity.nineth;

import choijaemin.homework.utility.nineth.CustomRandomNum;
import lombok.Getter;

import java.util.*;

@Getter
public class RoundManager {
    private Card card;
    private final int HEART = 1;

    private final int SPADE = 2;

    private final int CLOVER = 3;

    private final int DIAMOND = 4;
    private final int MAX_OF_SHAPE = 4;
    private final int MIN_OF_SHAPE = 1;
    private final int MAX_CARD_NUM = 13;
    private final int MIN_CARD_NUM = 1;
    private final int FIRST_DRAW_CNT = 3;

    public void firstCardDivide(PlayerManager playerManager){
        int randomShape;
        ArrayList<Integer> randomNum;

        for (int i = 0; i <FIRST_DRAW_CNT; i++) {
            makeFirstCardObj(playerManager , i);
            randomNum = new ArrayList<>();
            randomShape = makeCardNum(MAX_OF_SHAPE , MIN_OF_SHAPE);
            randomNum.add(makeCardNum(MAX_CARD_NUM , MIN_CARD_NUM));

            switch (randomShape){
                case HEART :
                    playerManager.getPlayer().get(i).getTotalCard().put("HEART" ,randomNum);
                    break;

                case SPADE :
                    playerManager.getPlayer().get(i).getTotalCard().put("SPADE" ,randomNum);
                    break;

                case CLOVER :
                    playerManager.getPlayer().get(i).getTotalCard().put("CLOVER" ,randomNum);
                    break;

                case DIAMOND :
                    playerManager.getPlayer().get(i).getTotalCard().put("DIAMOND" ,randomNum);
                    break;
            }
        }


    }
    public void selectOpenCard(PlayerManager playerManager){
        int openCard;
        Scanner sc = new Scanner(System.in);
        int selectOpenShape;
        int selectOpenNum;


        for (int i = 0; i < playerManager.getPlayerNum(); i++) {
            System.out.println("오픈할 카드 모양을 선택해주세요");
            System.out.println("1 - HEART\t" +
                    "2 - SPADE\t" +
                    "3 - CLOVER\t" +
                    "4 - DIAMOND");

            System.out.print("카드 입력 : ");
            selectOpenShape = sc.nextInt();

            System.out.print("오픈할 카드의 위치를 입력해주세요 : ");
            selectOpenNum = sc.nextInt();

            System.out.println("카드 오픈합니다");

            switch (selectOpenShape){
                case HEART :
                    openCard = playerManager.getPlayer().get(i).getTotalCard().get("HEART").get(selectOpenNum - 1);
                    System.out.println("플에이어가 오픈한 카드는 HART " + openCard +"입니다");
                    break;
                case SPADE:
                    openCard = playerManager.getPlayer().get(i).getTotalCard().get("SPADE").get(selectOpenNum - 1);
                    System.out.println("플에이어가 오픈한 카드는 SPADE " + openCard +"입니다");
                    break;
                case CLOVER:
                    openCard = playerManager.getPlayer().get(i).getTotalCard().get("CLOVER").get(selectOpenNum - 1);
                    System.out.println("플에이어가 오픈한 카드는 CLOVER " + openCard +"입니다");
                    break;
                case DIAMOND:
                    openCard = playerManager.getPlayer().get(i).getTotalCard().get("DIAMOND").get(selectOpenNum - 1);
                    System.out.println("플에이어가 오픈한 카드는 DIAMOND " + openCard +"입니다");
                    break;
                default:
                    System.out.println("잘못된 값을 입력 하셨습니다 다시 값을 입력해주세요");
                    continue;
            }
        }



    }

    public void makeFirstCardObj(PlayerManager playerManager , int idx){
        playerManager.getPlayer().get(idx).getTotalCard().put("HEART",new ArrayList<>());
        playerManager.getPlayer().get(idx).getTotalCard().put("SPADE",new ArrayList<>());
        playerManager.getPlayer().get(idx).getTotalCard().put("CLOVER",new ArrayList<>());
        playerManager.getPlayer().get(idx).getTotalCard().put("DIAMOND",new ArrayList<>());
    }

    private int makeCardNum(int max, int min){
        int ranNum = CustomRandomNum.makeRandomCardNum(max , min);

        return ranNum;
    }
}


