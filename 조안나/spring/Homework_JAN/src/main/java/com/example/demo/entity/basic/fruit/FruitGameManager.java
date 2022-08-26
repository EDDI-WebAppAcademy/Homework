package com.example.demo.entity.basic.fruit;

import java.util.*;

public class FruitGameManager {
    private final int FRUIT_ITEM_NUM = 1;
    private String CHARACTER_NAME = "KaiSa";
    private Map<String, LinkedList<Map<String, Integer>>> characterPubishingInfo;
    private LinkedList<Map<String, Integer>> characterInfoList;
    LinkedHashMap<String, Integer> characterInfo;

    /**
     * 기본 체력
     */
    private final int HP_VALUE = 500;

    /**
     * 기본 물리력
     */
    private final int AD_VALUE = 10;

    /**
     * 기본 주문력
     */
    private final int AP_VALUE = 10;

    /**
     * 시작 레벨
     */
    private final int LEVEL = 1;

    public FruitGameManager() {
        characterInfoList = new LinkedList<>();
        characterInfo = new LinkedHashMap<>();
    }

    /**
     * 게임 시작 메서드 <br>
     * (컨트롤러에서 구현하면 좋을 것 같음. . 일단 여기에)
     */
    public void GameStart(int PLAYER_NUM){
        //기존 캐릭터 정보 셋팅
        for (int i = 0; i < PLAYER_NUM; i++) {
            GameCharacter gameCharacter = new GameCharacter(CHARACTER_NAME);

            LinkedList<Map<String, Integer>> characterInfoList;
            characterInfoList = characterInfoList(characterInfoSet(HP_VALUE, AD_VALUE, AP_VALUE, LEVEL));
            System.out.println("characterInfoList : " + characterInfoList);

            characterPubishingInfo = gameCharacter.characterPubishingInfo(characterInfoList);
        }


        for (int i = 0; i < FRUIT_ITEM_NUM; i++) {
            // 캐릭터가 먹을 아이템 입력
            Scanner sc = new Scanner(System.in);
            System.out.println(CHARACTER_NAME+"가 먹을 아이템을 선택해주세요.");
            System.out.print("사과 / 오렌지/ 포도 / 빵 : ");
            String Input = sc.nextLine();

            UseItemManager itemManager = new UseItemManager();
            itemManager.useItem(Input, characterPubishingInfo, CHARACTER_NAME);

            System.out.println(CHARACTER_NAME+"님의 현재 정보 : " + characterPubishingInfo);
        }
    }


    /**
     * 기본 스킬 이름과 값을 설정하는 메서드
     * @return characterInfo Map
     */
    public LinkedHashMap<String, Integer> characterInfoSet(int hpValue, int adValue, int apValue, int levelValue){
        characterInfo.put("HP", hpValue);
        characterInfo.put("AD", adValue);
        characterInfo.put("AP", apValue);
        characterInfo.put("LEVEL", levelValue);
        System.out.println("characterInfo :" + characterInfo);
        return characterInfo;
    }

    /**
     * 스킬과 기본 값이 저장된 Map을 리스트에 저장하는 메서드
     * @param characterInfoSet
     * @return characterInfoList
     */
    public LinkedList<Map<String, Integer>> characterInfoList(LinkedHashMap<String, Integer> characterInfoSet){
        characterInfoList.add(characterInfoSet);
        System.out.println("characterInfoList :" + characterInfoList);
        return characterInfoList;
    }
}
