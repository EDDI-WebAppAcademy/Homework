package kr.eddi.demo.entity.basic.twelveth;

import lombok.Getter;

import java.util.*;

@Getter
public class PlayerManager {
    private int playerNum;
    private PockerCard pockerCard;
    private List<Player> playerList;

    // 어떤 사용자가 어떤 손패를 가지고 있는지 관리가 필요함
    // <사용자, 공개한 리스트>
    // 루프를 반복하게 되면 공개한 리스트에 정보를 추가하도록 구성해야함
    private Map<Player, List<Map<PockerCardShape, PockerCardCharacter>>> playerPubishingDeck;

    private int playerTurnPriorityIdx = 0;

    public PlayerManager(int playerNum) {       // 플레이어매니저 생성할 때
                                               //  플레이어 수만큼 플레이어 객체 생성 +
                                               // 포커카드 객체 생성 > 포커카드 섞기 +
                                                // 플레이어 오픈 카드 해시맵 생성

        this.playerNum = playerNum;                //  이 클래스에서 선언한 playerNum은 인자로 받아오는 PlayerNum 값이다.
        playerList = new ArrayList<>();             // (1)  플레이어 리스트 만듦

        for (int i = 0; i < playerNum; i++) {         // 플레이어 수 만큼 Player 객체 생성해서 배열에 넣음
            playerList.add(new Player());
        }

        pockerCard = new PockerCard();                 // 포커카드 객체 생성
        pockerCard.shuffle();                          // 카드 섞기

        playerPubishingDeck = new HashMap<>();         // 플레이어 오픈카드 해시맵 생성
    }

    // 예로 4명
    // 0  1  2  3
    // 만약 우선권을 2번이 가지게 되면
    // 2, 3, 0, 1 ->

    public void playPockerGame(int currentRound) {                               // (2-3) 실제 포커게임 기능(게임 스타트 메소드에서 호출됨)
                                                                 //이 메소드가 1번 동작하는건 1라운드를 의미하며, do - while문은 통해 라운드가 5가 될때까지 반복함
        // 이 루프는 순서가 바뀌는 순간 종료되지 않습니다 ........
        // 정상 루틴     0, 1, 2, 3 -> playerNum = 4, idx = 0 그러므로 4가 되면 종료
        // 순서 변경 루틴 2, 3, 0, 1 -> playerNum = 4, idx = 2 그러므로 2가 되면 종료
        // 실제 루프의 인덱스 카운팅 방식으로 해결할 수 없으므로 루프 카운트 자체를 직접 계산하도록 한다.
        int loopCnt = 0;

        for (int i = 0 + playerTurnPriorityIdx; i < playerNum + playerTurnPriorityIdx; i++) {            // 우선순위가진 플레이어 idx + 플레이어 수만큼 반복
                                                                                                //-> 예를 들어 우선순위(playerTurnPriorityIdx)가 3번째 플레이어
                                                                                       //-> i< 4(playerNum)+3(playerTurnPriorityIdx) => 7이므로 시작값 3, 4, 5, 6 플레이어수만큼 4번 돌아가는 것 동일
            // 4. 참여 순서대로 플레이어들에게 패를 돌린다. -> 카드 생성
            // 8. 추가패를 받는다.
            // 실제로 이 부분은 4번 8번이 함께 동작하므로 일관성을 유지하기 위해 별도의 함수를 배치하는 것이 좋아보임
            // 실제로 추가패를 받는 작업과 공개할 패를 받는 작업의 연관성이 존재함
            // 좋은 케이스: 여러 기능을 한 곳에서 처리하려고 하다보니 중복 코드가 발생하게 되었음
            //           작은 기능을 개발할 때는 크게 문제가 되지 않지만
            //           기능이 커질수록 분리를 안하는 경우 아래와 같이 중복 코드를 작성하게 됨.
            loopCnt++;                                                                                  // loopCnt +1 증가시킴

            if (i >= playerNum) { i -= playerNum; }  // i를 3으로 가정, 만약 i 값이 플레이어넘버 4 이상이면 -> i는 i-playerNum(4) = 0으로 바꿈 , 즉 3 > 0 > 1> 2 플레이어순으로 동작

            System.out.println("현재 순서: " + i);                                        // 콘솔에 표시되는 사항(현재 순서) -2

            acquireNewCards(i, currentRound);                                        // 추가 패를 받는다

            // 5. 플레이어들은 공개할 패를 선택한다.
            publishingPlayerCard(i, currentRound);

            // 9. 베팅 머니 추가
            if (loopCnt == playerNum) { break; }        // loopCnt는 currentRound 에서 플레이어들이 1번씩 돌아가도록 세는 변수
                                                        // 반복 한번 돌때마다 +1씩 증가, -> 즉, 플레이어 수만큼 증가하고 플레이어 수가 같아지면 반복문 종료시킴  -> 1 라운드 종료

        }

        // 7. 가장 높은 패에게 턴 우선권을 제공한다.
        //    compareTo를 활용해서 비교를 하도록 구성해야함
        //    또한 실제 숫자는 ACE, 2 ~ 10, J, Q, K 로 13개씩 구성됨
        //    페어, 트리플, 포카드는 shape을 비교해야함
        //    하이카드는 문양과 숫자가 높은넘
        //    스트레이트, 플러쉬 등등의 케이스를 어떻게 판정할지에 대한 전략이 필요함.
        //    7-1. 정렬을 통해서 숫자들을 배치해야함
        //    7-2. 내용을 이동하면서 숫자가 순차적이지 않으면 스트레이트 x 순차적으로 5개가 배치되면 스트레이트
        //    7-3. 문양이 같은지 판별해서 스트레이트 플러쉬를 감지
        //    7-4. 위 조건을 만족하면서 10, J, Q, K, A로 연속적 배치가 되어 있다면 로열 플러쉬
        //    이제 나머지는 사실상 그냥 문양만 보거나 숫자만 확인하면 되서 어렵지 않음.
        //    풀하우스 - 같은 숫자 3 + 같은 숫자 2
        //    여기 파트에서 7-1 ~ 7-4 파트가 마지막 고비임.
        playerTurnPriorityIdx = checkPlayersPriority();

        //System.out.println(playerPubishingDeck);
    }

    public int checkPlayersPriority() {
        // 이 부분은 결국 공개패를 봐야하는 부분임. -> 공개패: playerPubishingDeck (Map)
        //                                 -> mapPlayerPublishingDeck이였으면 더 좋았음.
        // 초기에 playerPublishingDeck을 클래스화 하여 작업했으면
        // compareTo(), compare() 등을 사용함에 문제가 없었겠지만
        // 귀차니즘 때문에 이렇게 만들게 되어 직접 프로그램을 작성해야함
        List<Map<PockerCardShape, PockerCardCharacter>> sameCardCharacters[] = new List[playerNum];

        for (int i = 0; i < playerNum; i++) {
            //System.out.println("사용자 공개패: " + playerPubishingDeck.get(playerList.get(i)));
            // 페어, 트리플, 포카드는 감지함.
            sameCardCharacters[i] = findSameCardCharacters(i);
            System.out.println(sameCardCharacters[i]);
        }

        // 여기서는 추출된 사용자 정보를 바탕으로 우선순위 인덱스를 판정한다.
        return decisionPlayerTurnPriority(sameCardCharacters);
    }

    public int decisionPlayerTurnPriority(
            List<Map<PockerCardShape, PockerCardCharacter>> sameCardCharacters[]) {

        int sameAmount[] = new int[playerNum];

        for (int i = 0; i < playerNum; i++) {
            sameAmount[i] = sameCardCharacters[i].size();
        }

        // 실제로는 List로 만들어서 sort를 활용하도록 만드는 것이 더 좋았음.
        if (sameAmount[0] > sameAmount[1]) {
            return 0;
        } else if (sameAmount[0] < sameAmount[1]) {
            return 1;
        }

        // 둘 다 조합 패턴이 같은 상황에선 문양과 숫자 크기를 가지고 승부해야함
        int processedPlayerTurnIdx = comparePlayerCardCharacter(sameCardCharacters);

        if (processedPlayerTurnIdx != -1) {
            return processedPlayerTurnIdx;
        }

        return comparePlayerCardShape(sameCardCharacters);
    }


    // 페어, 트리플, 포카드를 가정했으므로 사실상 스페이드를 가진 인덱스 리턴하면 끝남.
    public int comparePlayerCardShape(
            List<Map<PockerCardShape, PockerCardCharacter>> sameCardCharacters[]) {

        int sameCardPatternListLength;

        for (int i = 0; i < playerNum; i++) {
            sameCardPatternListLength = sameCardCharacters[i].size();

            for (int j = 0; j < sameCardPatternListLength; j++) {
                for (PockerCardShape keyPockerCardShape: sameCardCharacters[i].get(j).keySet()) {
                    // 스페이드 없이 페어가 나올 수도 있음.
                    // 다이아 vs 클로버, 하트 vs 클로버
                    // 결국 플레이어가 어떤 문양을 가지고 있는지 관리가 필요함.
                    // [플레이어 인덱스, 문양] -> 같은 숫자가 4개면 스페이드 무조건 포함
                    if (keyPockerCardShape == PockerCardShape.SPADE) {
                        return i;
                    }
                }
            }
        }

        return -1;
    }

    // 페어, 트리플, 포카드를 가정했음
    // 실제로 여러 조건이 들어가면 이 부분은 훨씬 더 많이 복잡해짐.
    // 그럼 정말 모든 기능을 다 조각조각 내고 작성해야함.
    public int comparePlayerCardCharacter(
            List<Map<PockerCardShape, PockerCardCharacter>> sameCardCharacters[]) {

        int cardValue[] = new int[playerNum];

        for (int i = 0; i < playerNum; i++) {
            if (sameCardCharacters[i].size() == 0) {
                cardValue[i] = 0;
                continue;
            }

            Map<PockerCardShape, PockerCardCharacter> currentCard = sameCardCharacters[i].get(0);
            Map.Entry<PockerCardShape, PockerCardCharacter> currentCardEntry = currentCard.entrySet().iterator().next();
            PockerCardCharacter currentCardCharacter = currentCardEntry.getValue();
            cardValue[i] = currentCardCharacter.getValue();
        }

        if (cardValue[0] == 0 && cardValue[1] == 0) { return 0; }

        if (cardValue[0] > cardValue[1]) {
            return 0;
        } else if (cardValue[0] < cardValue[1]) {
            return 1;
        } else {
            return -1;
        }
    }

    // 실제로 상대편과 겨룰때 같은 페어가 숫자 차이, 문양 차이가 존재할 수 있음.
    // 그러므로 실제 리턴값은 [문양, 숫자, 개수] 형태의 List가 되어야함.
    // [스페이드, 3], [클로버, 3], 2 이러한 형태로 구성되어있음.
    // 그렇다면 실제로 이것을 리턴하기 위해선 ???
    // 결국 [스페이드, 3], [클로버, 3] 을 리턴하고 몇 개인지 정보는 리스트의 크기로 판정한다.
    // 실제로 스트레이트, 풀하우스, 로열플러쉬는 5개가 만들어지기 때문에
    // 모든 케이스를 려한다면 별도의 enum 태그가 필요함 SAME_SIZE_DECISION 같은 형태
    // ex) [스페이드, 3], [클로버, 3], [PockerCardPattern.TWO_PAIR, PockerCardPattern.TWO_PAIR]
    public List<Map<PockerCardShape, PockerCardCharacter>> findSameCardCharacters(int playerIdx) {
        int sameCharacterCnt = 0;
        List<Map<PockerCardShape, PockerCardCharacter>> publishingCards;
        publishingCards = playerPubishingDeck.get(playerList.get(playerIdx));

        List<Map<PockerCardShape, PockerCardCharacter>> sameCardCharacterList = new ArrayList<>();

        int publishingDeckSize = playerPubishingDeck.get(playerList.get(playerIdx)).size();

        for (int currentCardIdx = 0; currentCardIdx < publishingDeckSize; currentCardIdx++) {
            Map<PockerCardShape, PockerCardCharacter> currentCard = publishingCards.get(currentCardIdx);
            Map.Entry<PockerCardShape, PockerCardCharacter> currentCardEntry = currentCard.entrySet().iterator().next();  //iterator
            PockerCardCharacter currentCardCharacter = currentCardEntry.getValue();

            for (int otherCardIdx = 0; otherCardIdx < publishingDeckSize; otherCardIdx++) {
                if (currentCardIdx == otherCardIdx) { continue; }

                Map<PockerCardShape, PockerCardCharacter> otherCard = publishingCards.get(otherCardIdx);
                Map.Entry<PockerCardShape, PockerCardCharacter> otherCardEntry = otherCard.entrySet().iterator().next();
                PockerCardCharacter otherCardCharacter = otherCardEntry.getValue();

                if (currentCardCharacter.equals(otherCardCharacter)) {
                    //System.out.println("currentCardCharacter: " + currentCardCharacter);
                    //System.out.println("otherCardCharacter: " + otherCardCharacter);
                    // [스페이드, 3], [클로버, 3], [PockerCardPattern.TWO_PAIR, PockerCardPattern.TWO_PAIR]
                    sameCardCharacterList.add(publishingCards.get(otherCardIdx));
                }
            }
        }

        return sameCardCharacterList;
    }

    public void publishingPlayerCard(int playerIdx, int currentRound) { // 사용자가 입력한 오픈카드를 받아와서 playerPubishingDeck 해시맵에 저장하는 메소드
        // (1) newPlayerPublishingDeckList       : 0라운드- 플레이어가 오픈하겠다고 입력하여 선택한 카드덱 리스트 받는 배열(ArrayList). 1라운드 이후부터는 1개의 새로 뽑은 카드값 가짐
        //                                             -> 형태: {{DIAMOND=SIX}}
        // (2) existingPlayerPublishingDeckList  : (1)번 항목의 배열을 받아서 저장하는 배열 (ArrayList)  -> (3)항목에 value 값인 플레이어오픈카드덱 자리에 들어감
        //                                       :     -> 형태: {{DIAMOND=SIX} , {CLOVER=EIGHT} , , } -> 플레이어들의 오픈카드 리스트 여러개를 저장한 배열
        // (3) playerPubishingDeck               : (3) PlayerManager를 생성할 때 생성되는 카드덱으로 해시맵(플레이어인덱스, 플레이어오픈카드덱) 형태로 구성됨 (HashMap)
        //                                       :     플레이어 각각의 오픈카드 리스트를 저장 ( { {{0번째 플레이어 카드덱}, {0번쩨 플레이어 오픈카드덱}}   ,   {{1번째 플레이어 카드덱}, {1번쩨 플레이어 오픈카드덱}} )
        //                                       :     -> 형태: { Player(cardsDeck)=[{DIAMOND=SIX}, {CLOVER=EIGHT}, {CLOVER=TEN}]) ,  {CLOVER=EIGHT} }
        // (4) playerList.get(i)                 : 플레이어 i번째의 카드덱 리스트 -> 형태: [{DIAMOND=SIX}, {CLOVER=EIGHT}, {CLOVER=TEN}]

        if (currentRound == 0) {
            List<Map<PockerCardShape, PockerCardCharacter>> newPlayerPublishingDeckList = new ArrayList<>(); // (1) 항목
            newPlayerPublishingDeckList.add(playerList.get(playerIdx).publishingPlayersCard());  // i번째 플레이어의 오픈카드덱을 add해줌
                                                                                                // 여기에서 publishingPlayersCard()는 현재 메소드가 아닌 Player 클래스의 메소드

            // 기존 해쉬맵에서 밸류값인 리스트를 가져와서 해당 값에 내용을 추가하고 다시 put해서 넣어야함.
            List<Map<PockerCardShape, PockerCardCharacter>> existingPlayerPublishingDeckList = new ArrayList<>();

            if (playerPubishingDeck.get(playerList.get(playerIdx)) == null) {                   // idx 번째 플레이어 리스트에 playerPubishingDeck에 저장되어 있지 않은 경우
                                                                                                 // 즉, idx = 0,1,,로 증가하므로 값을 넣은 적 없으니 항상 null임
                                                                                                 // 즉, 무조건 if문 안에 조건이 실행됨
                existingPlayerPublishingDeckList = newPlayerPublishingDeckList;                   // existing에 idx번째 player의 오픈카드덱을 저장해라
                System.out.println(existingPlayerPublishingDeckList);
            }
//            else {                                                                                     // else는 없어도 되는 문장(동작하기 않음) ->
//                existingPlayerPublishingDeckList = playerPubishingDeck.get(playerList.get(playerIdx));  //해시맵.get()은 인자로 전달된 key에 해당하는 value를 리턴
//                int existingDeckSize = existingPlayerPublishingDeckList.size();                         //
//
//                existingPlayerPublishingDeckList.add(newPlayerPublishingDeckList.get(0));
//            }

            playerPubishingDeck.put(playerList.get(playerIdx), existingPlayerPublishingDeckList);
        }
    }

    public void acquireNewCards(int playerIdx, int currentRound) {  // currentRound = 0일때 3장, 그외 라운드 1장씩 플레이어가 카드얻음
        if (currentRound == 0) {                                                    //(1) currentRound = 0일때 3장 얻기
            for (int i = 0; i < 3; i++) {
                playerList.get(playerIdx).acquireNewCards(pockerCard.divideCard());    // 여기에서 acquireNewCards는 현재 메소드가 아닌 Player 클래스의 메소드
            }
        } else {                                                                                     //currentRound 가 1 이상일 때 1장씩 카드 얻기
            List<Map<PockerCardShape, PockerCardCharacter>> existingPlayerPublishingDeckList;                 // (1) existingPlayerPublishingDeckList 선언 -> 모든 오픈패 저장용
            List<Map<PockerCardShape, PockerCardCharacter>> newPlayerPublishingDeckList = new ArrayList<>();  // (2) newPlayerPublishingDeckList 선언 -> 새로뽑은 카드 저장용
            newPlayerPublishingDeckList.add(pockerCard.divideCard());                                         // (3) newPlayerPublishingDeckList에

            playerList.get(playerIdx).acquireNewCards(newPlayerPublishingDeckList.get(0));

            if (playerPubishingDeck.get(playerList.get(playerIdx)) == null) {
                existingPlayerPublishingDeckList = newPlayerPublishingDeckList;
            } else {
                existingPlayerPublishingDeckList = playerPubishingDeck.get(playerList.get(playerIdx));
                int existingDeckSize = existingPlayerPublishingDeckList.size();

                existingPlayerPublishingDeckList.add(newPlayerPublishingDeckList.get(0));
            }

            playerPubishingDeck.put(playerList.get(playerIdx), existingPlayerPublishingDeckList);
        }
    }
}