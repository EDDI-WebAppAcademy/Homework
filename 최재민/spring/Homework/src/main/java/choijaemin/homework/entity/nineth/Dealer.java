package choijaemin.homework.entity.nineth;

import choijaemin.homework.utility.nineth.CustomRandomNum;
import lombok.Getter;

import java.util.*;

@Getter
public class Dealer {
    private Card card;
    private final int HART = 1;

    private final int SPADE = 2;

    private final int CLOVER = 3;

    private final int DIAMOND = 4;
    private HashMap <String , ArrayList<Integer>>firstCard;
    private final int MAX_OF_SHAPE = 4;
    private final int MIN_OF_SHAPE = 1;
    private final int MAX_CARD_NUM = 13;
    private final int MIN_CARD_NUM = 1;
    private final int FIRST_DRAW_CNT = 3;

    public void firstCardDivide(){
        firstCard = new LinkedHashMap();
        card = new Card();
        makeFirstCardObj(); // firstCard.put("HART",new ArrayList<>()); 식으로 list 할당

        int randomShape;
        int randomNum;
        int[] num ;

        for (int i = 0; i <FIRST_DRAW_CNT; i++) {
            randomShape = makeCardNum(MAX_OF_SHAPE , MIN_OF_SHAPE);
            randomNum = makeCardNum(MAX_CARD_NUM , MIN_CARD_NUM);

            switch (randomShape){
                case HART :
                    num = card.getHart();
                    firstCard.get("HART").add(num[randomNum]);
                    break;

                case SPADE :
                    num = card.getSpade();
                    firstCard.get("SPADE").add(num[randomNum]);
                    break;

                case CLOVER :
                    num = card.getColver();
                    firstCard.get("CLOVER").add(num[randomNum]);
                    break;

                case DIAMOND :
                    num = card.getDiamond();
                    firstCard.get("DIAMOND").add(num[randomNum]);
                    break;
            }
        }


    }
    public void selectOpenCard(HashMap<String ,ArrayList<Integer>> totalCard){
        int openCard;
        Scanner sc = new Scanner(System.in);

        int selectOpenShape;
        int selectOpenNum;

        while (true){
            try {
                System.out.println("오픈할 카드 모양을 선택해주세요");
                System.out.println("1 - HART\t" +
                        "2 - SPADE\t" +
                        "3 - CLOVER\t" +
                        "4 - DIAMOND");
                System.out.print("카드 입력 : ");
                selectOpenShape = sc.nextInt();
                System.out.print("오픈할 카드의 위치를 입력해주세요 : ");
                selectOpenNum = sc.nextInt();
                System.out.println("카드 오픈합니다");
                switch (selectOpenShape){
                    case HART :
                        openCard = totalCard.get("HART").get(selectOpenNum - 1);
                        System.out.println("플에이어가 오픈한 카드는 HART " + openCard +"입니다");
                        break;
                    case SPADE:
                        openCard = totalCard.get("SPADE").get(selectOpenNum - 1);
                        System.out.println("플에이어가 오픈한 카드는 SPADE " + openCard +"입니다");
                        break;
                    case CLOVER:
                        openCard = totalCard.get("CLOVER").get(selectOpenNum - 1);
                        System.out.println("플에이어가 오픈한 카드는 CLOVER " + openCard +"입니다");
                        break;
                    case DIAMOND:
                        openCard = totalCard.get("DIAMOND").get(selectOpenNum - 1);
                        System.out.println("플에이어가 오픈한 카드는 DIAMOND " + openCard +"입니다");
                        break;
                }
                break;
            }catch (Exception e){
                System.out.println("잘못된 값을 입력하셨습니다, 다시 입력 부탁드립니다.");
                continue;
            }

        }

    }

    public void makeFirstCardObj(){
        firstCard.put("HART",new ArrayList<>());
        firstCard.put("SPADE",new ArrayList<>());
        firstCard.put("CLOVER",new ArrayList<>());
        firstCard.put("DIAMOND",new ArrayList<>());
    }

    private int makeCardNum(int max, int min){
        int ranNum = CustomRandomNum.makeRandomCardNum(max , min);

        return ranNum;
    }
}


