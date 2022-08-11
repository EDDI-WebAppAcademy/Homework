package com.example.demo.entity.basic.poker;

import lombok.Getter;

import java.util.*;

@Getter
public class PlayerManager {
    private int playerNum;
    private PokerCard pokerCard;
    private List<Player> playerList;

    // 어떤 사용자가 어떤 손패를 가지고 있는지 관리가 필요함
    // <사용자, 공개한 리스트>
    // 루프를 반복하게 되면 공개한 리스트에 정보를 추가하도록 구성해야함

    /**
     * 플레이어가 가지고 있는 카드 <사용자, 공개할 카드 리스트<문양,숫자>>
     */
    private Map<Player, List<Map<PokerCardShape, PokerCardCharacter>>> playerPubishingDeck;

    /**
     * 턴 우선권을 가진 플레이어 인덱스
     */
    private int playerTurnPriorityIdx = 0;


    /**
     * [플레이어를 관리하는 메서드] <br>
     * 플레이어 수 만큼 플레이어 리스트를 생성하고, <br>
     * 플레이어 리스트들에 new Player() 저장 <br>
     * 카드 생성 명령하고 섞어줌 <br>
     * 플레이어 현재 덱 객체 생성
     * @param playerNum 플레이어 수
     */
    public PlayerManager(int playerNum) {
        this.playerNum = playerNum;
        playerList = new ArrayList<>();

        //카드 덱 add
        for (int i = 0; i < playerNum; i++) {
            playerList.add(new Player());
        }

        pokerCard = new PokerCard();
        pokerCard.shuffle();

        playerPubishingDeck = new HashMap<>();
    }



    // 예로 4명
    // 0  1  2  3
    // 만약 우선권을 2번이 가지게 되면
    // 2, 3, 0, 1 ->
    /**
     * 포커게임 플레이하는 메서드
     * @param currentRound 현재 라운드
     */
    public void playpokerGame(int currentRound) {
        // 이 루프는 순서가 바뀌는 순간 종료되지 않습니다 ........
        // 정상 루틴     0, 1, 2, 3 -> playerNum = 4, idx = 0 그러므로 4가 되면 종료
        // 순서 변경 루틴 2, 3, 0, 1 -> playerNum = 4, idx = 2 그러므로 2가 되면 종료
        // 실제 루프의 인덱스 카운팅 방식으로 해결할 수 없으므로 루프 카운트 자체를 직접 계산하도록 한다.
        int loopCnt = 0;

        // 우선순위부터 카드를 받음 (처음엔 0)
        for (int i = 0 + playerTurnPriorityIdx; i < playerNum + playerTurnPriorityIdx; i++) {
            // 4. 참여 순서대로 플레이어들에게 패를 돌린다. -> 카드 생성
            // 8. 추가패를 받는다.
            // 실제로 이 부분은 4번 8번이 함께 동작하므로 일관성을 유지하기 위해 별도의 함수를 배치하는 것이 좋아보임
            // 실제로 추가패를 받는 작업과 공개할 패를 받는 작업의 연관성이 존재함
            // 좋은 케이스: 여러 기능을 한 곳에서 처리하려고 하다보니 중복 코드가 발생하게 되었음
            //           작은 기능을 개발할 때는 크게 문제가 되지 않지만
            //           기능이 커질수록 분리를 안하는 경우 아래와 같이 중복 코드를 작성하게 됨.
            loopCnt++;

            if (i >= playerNum) { i -= playerNum; }

            System.out.println("현재 순서: " + i);

            // 라운드마다 정해놓은 카드 숫자대로 나눠주고,
            // 새롭게 받은 카드들을 플레이어가 가지고있는 카드덱으로 저장(playerPubishingDeck)
            acquireNewCards(i, currentRound);
            publishingPlayerCard(i, currentRound);

            //플레이어 수만큼 루프 돌았으면 종료
            if (loopCnt == playerNum) { break; }
        }
            // 9. 베팅 머니 추가

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
            // 5. 플레이어들은 공개할 패를 선택한다.

        // 턴 우선권을 가진 플레이어 비교
        playerTurnPriorityIdx = checkPlayersPriority();

        //System.out.println(playerPubishingDeck);
    }

    /**
     * 플레이어들이 공개한 패를 비교하여 <br>
     * 우선권을 가진 플레이어 인덱스를 알려주는 메서드
     * @return 우선순위인 플레이어 인덱스 번호
     */
    public int checkPlayersPriority() {
        // 이 부분은 결국 공개패를 봐야하는 부분임. -> 공개패: playerPubishingDeck (Map)
        //                                 -> mapPlayerPublishingDeck이였으면 더 좋았음.
        // 초기에 playerPublishingDeck을 클래스화 하여 작업했으면
        // compareTo(), compare() 등을 사용함에 문제가 없었겠지만
        // 귀차니즘 때문에 이렇게 만들게 되어 직접 프로그램을 작성해야함
        List<Map<PokerCardShape, PokerCardCharacter>> sameCardCharacters[] = new List[playerNum];

        for (int i = 0; i < playerNum; i++) {
            //System.out.println("사용자 공개패: " + playerPubishingDeck.get(playerList.get(i)));
            // 페어, 트리플, 포카드는 감지함.

            // 같은 숫자 찾은거 sameCardCharacters에 넣기
            sameCardCharacters[i] = findSameCardCharacters(i);
            System.out.println(sameCardCharacters[i]);
        }

        // 여기서는 추출된 사용자 정보를 바탕으로 우선순위 인덱스를 판정한다.
        return decisionPlayerTurnPriority(sameCardCharacters);
    }


    /**
     * 턴 우선권을 가지는 플레이어를 판단하는 메서드 <br>
     * 같은 숫자를 몇개 가졌는지 비교하여 우열을 가림
     * @param sameCardCharacters
     * @return 우선순위인 플레이어 인덱스 번호
     */
    public int decisionPlayerTurnPriority(
            List<Map<PokerCardShape, PokerCardCharacter>> sameCardCharacters[]) {

        int sameAmount[] = new int[playerNum];

        // 같은 거 몇개 가졌는지 사이즈로 체크
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

        // 같은 값을 가진 카드 개수가 같을 경우 그 카드들의 숫자 크기를 비교 (페어 vs 트리플 vs 포카드)
        int processedPlayerTurnIdx = comparePlayerCardCharacter(sameCardCharacters);

        // 만약 -1이 나오면 리턴하지 않음
        if (processedPlayerTurnIdx != -1) {
            return processedPlayerTurnIdx;
        }

        // 페어를 확인하고 같은 수의 페어중 더 높은 문양을 가진 플레이어를 알려줌
        // (스페이드를 가진 플레이어가 이김)
        return comparePlayerCardShape(sameCardCharacters);
    }


    // 페어, 트리플, 포카드를 가정했으므로 사실상 스페이드를 가진 인덱스 리턴하면 끝남.

    /**
     * 카드의 문양 우선순위를 가려주는 메서드 <br>
     * (스페이드를 가진 플레이어를 찾음)
     * @param sameCardCharacters 같은 숫자 카드가 저장된 리스트
     * @return 우선순위인 플레이어 인덱스 번호 <br>
     *          스페이드가 포함되지 않았으면 -1 리턴
     */
    public int comparePlayerCardShape(
            List<Map<PokerCardShape, PokerCardCharacter>> sameCardCharacters[]) {

        int sameCardPatternListLength;

        for (int i = 0; i < playerNum; i++) {
            sameCardPatternListLength = sameCardCharacters[i].size();

            for (int j = 0; j < sameCardPatternListLength; j++) {
                for (PokerCardShape keyPokerCardShape : sameCardCharacters[i].get(j).keySet()) {
                    // 스페이드 없이 페어가 나올 수도 있음.
                    // 다이아 vs 클로버, 하트 vs 클로버
                    // 결국 플레이어가 어떤 문양을 가지고 있는지 관리가 필요함.
                    // [플레이어 인덱스, 문양] -> 같은 숫자가 4개면 스페이드 무조건 포함
                    if (keyPokerCardShape == PokerCardShape.SPADE) {
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

    /**
     * 같은 숫자를 가진 것 중 <br>
     * 어느 숫자가 더 높은 순위인지 가려내는 메서드 <br>
     * 페어, 트리플, 포카드만 가정
     * @param sameCardCharacters 같은 숫자 카드가 저장된 리스트
     * @return 우선순위인 플레이어 인덱스 번호
     */
    public int comparePlayerCardCharacter(
            List<Map<PokerCardShape, PokerCardCharacter>> sameCardCharacters[]) {

        int cardValue[] = new int[playerNum];

        for (int i = 0; i < playerNum; i++) {
            if (sameCardCharacters[i].size() == 0) {
                cardValue[i] = 0;
                continue;
            }

            Map<PokerCardShape, PokerCardCharacter> currentCard = sameCardCharacters[i].get(0);
            Map.Entry<PokerCardShape, PokerCardCharacter> currentCardEntry = currentCard.entrySet().iterator().next();
            PokerCardCharacter currentCardCharacter = currentCardEntry.getValue();
            cardValue[i] = currentCardCharacter.getValue();
        }

        // 값 (카드 숫자)끼리 비교
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
    // ex) [스페이드, 3], [클로버, 3], [PokerCardPattern.TWO_PAIR, PokerCardPattern.TWO_PAIR]

    /**
     * 같은 숫자(character)를 가진 카드를 찾는 메서드
     * @param playerIdx
     * @return sameCardCharacterList 같은거 찾아서 저장한 리스트
     */
    public List<Map<PokerCardShape, PokerCardCharacter>> findSameCardCharacters(int playerIdx) {
        int sameCharacterCnt = 0;
        List<Map<PokerCardShape, PokerCardCharacter>> publishingCards;
        //플레이어가 가지고 있는 카드 가져옴
        publishingCards = playerPubishingDeck.get(playerList.get(playerIdx));

        // 같은 거 있으면 저장할 리스트 생성
        List<Map<PokerCardShape, PokerCardCharacter>> sameCardCharacterList = new ArrayList<>();

         // 플레이어가 가지고 있는 카드 개수
        int publishingDeckSize = playerPubishingDeck.get(playerList.get(playerIdx)).size();

        // 플레이어가 가지고 있는 카드 값 분리해서 저장
        for (int currentCardIdx = 0; currentCardIdx < publishingDeckSize; currentCardIdx++) {
            Map<PokerCardShape, PokerCardCharacter> currentCard = publishingCards.get(currentCardIdx);
            Map.Entry<PokerCardShape, PokerCardCharacter> currentCardEntry = currentCard.entrySet().iterator().next();
            PokerCardCharacter currentCardCharacter = currentCardEntry.getValue();

            //비교할 카드도 똑같이
            for (int otherCardIdx = 0; otherCardIdx < publishingDeckSize; otherCardIdx++) {
                // 똑같은건 건너뛰기
                if (currentCardIdx == otherCardIdx) { continue; }

                Map<PokerCardShape, PokerCardCharacter> otherCard = publishingCards.get(otherCardIdx);
                Map.Entry<PokerCardShape, PokerCardCharacter> otherCardEntry = otherCard.entrySet().iterator().next();
                PokerCardCharacter otherCardCharacter = otherCardEntry.getValue();

                // 카드 비교해서 같은거 저장
                if (currentCardCharacter.equals(otherCardCharacter)) {
                    //System.out.println("currentCardCharacter: " + currentCardCharacter);
                    //System.out.println("otherCardCharacter: " + otherCardCharacter);
                    // [스페이드, 3], [클로버, 3], [PokerCardPattern.TWO_PAIR, PokerCardPattern.TWO_PAIR]
                    sameCardCharacterList.add(publishingCards.get(otherCardIdx));
                }
            }
        }
        return sameCardCharacterList;
    }

    /**
     * 첫 번째 라운드에서 맨 처음 받은 카드 3개를 <br>
     * playerPubishingDeck에 저장해주는 메서드 <br>
     * (얘네도 플레이어가 가지고있는 손패로 따로 관리 될 필요가 있어서임)
     * @param playerIdx
     * @param currentRound
     */
    public void publishingPlayerCard(int playerIdx, int currentRound) {
        if (currentRound == 0) {
            //새로운 플레이어 현재 덱 리스트를 생성하고
            List<Map<PokerCardShape, PokerCardCharacter>> newPlayerPublishingDeckList = new ArrayList<>();
            // 플레이어가 공개하기로 선택한 카드를 저장한다.
            newPlayerPublishingDeckList.add(playerList.get(playerIdx).publishingPlayersCard());

            // 기존 해쉬맵에서 밸류값인 리스트를 가져와서 해당 값에 내용을 추가하고 다시 put해서 넣어야함.
            List<Map<PokerCardShape, PokerCardCharacter>> existingPlayerPublishingDeckList;

            if (playerPubishingDeck.get(playerList.get(playerIdx)) == null) {
                existingPlayerPublishingDeckList = newPlayerPublishingDeckList;
            } else {
                existingPlayerPublishingDeckList = playerPubishingDeck.get(playerList.get(playerIdx));
                int existingDeckSize = existingPlayerPublishingDeckList.size();

                existingPlayerPublishingDeckList.add(newPlayerPublishingDeckList.get(0));
            }
            //<플레이어, 받은 카드 <문양,숫자>>형태로 플레이어가 가지고 있는 카드 리스트 저장
            playerPubishingDeck.put(playerList.get(playerIdx), existingPlayerPublishingDeckList);
        }
    }


    /**
     * 플레이어들이 새로운 카드를 얻고 <br>
     * 공개할 카드들 playerPubishingDeck에 추가해주는 메서드
     * @param playerIdx 플레이어 인덱스
     * @param currentRound 현재 라운드
     */
    public void acquireNewCards(int playerIdx, int currentRound) {
        // 첫 번째 라운드에서 카드 3장씩 나눠줌 (얘는 공개될 필요 X)
        if (currentRound == 0) {
            for (int i = 0; i < 3; i++) {
                playerList.get(playerIdx).acquireNewCards(pokerCard.divideCard());
            }

        // 두 번째 라운드 부터
        } else {
            //기존 나눠받은 플레이어의 카드 리스트
            List<Map<PokerCardShape, PokerCardCharacter>> existingPlayerPublishingDeckList;

            // 새롭게 받은 카드 리스트
            List<Map<PokerCardShape, PokerCardCharacter>> newPlayerPublishingDeckList = new ArrayList<>();
            // 나눠준 카드 newPlayerPublishingDeckList에 저장
            newPlayerPublishingDeckList.add(pokerCard.divideCard());

            //현재 플레이어 리스트에 새로운 나눠준 카드 저장
            playerList.get(playerIdx).acquireNewCards(newPlayerPublishingDeckList.get(0));


            //playerPubishingDeck 인덱스 값 null 체크 => 항상 true?
            if (playerPubishingDeck.get(playerList.get(playerIdx)) == null) {
                // 아무것도 없으면 새로 나눠준 카드 existingPlayerPublishingDeckList에 저장
                existingPlayerPublishingDeckList = newPlayerPublishingDeckList;

            } else {
                // 기존 나눠받은 플레이어 카드 = 플레이어가 가지고 있는 카드 동기화
                existingPlayerPublishingDeckList = playerPubishingDeck.get(playerList.get(playerIdx));
                int existingDeckSize = existingPlayerPublishingDeckList.size();

                // 기존존 나눠받은 플레이어 카드에 새로 받은 카드 추가
                existingPlayerPublishingDeckList.add(newPlayerPublishingDeckList.get(0));
            }

            //<플레이어, 받은 카드 <문양,숫자>>형태로 새로 받은 카드 저장
            playerPubishingDeck.put(playerList.get(playerIdx), existingPlayerPublishingDeckList);
        }
    }
}

