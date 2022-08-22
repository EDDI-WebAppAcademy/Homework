package kr.eddi.demo.homework.entity.nineth;

import java.util.Map;

public class Character {

    private final int CHARACTER_TYPE_NUM = 7;

    private final int health = 100;  // 기본 피

    public Map<CharacterType, CharacterStats> characterPower;




}



// 캐릭터  종류 관리(마법사, 궁수, 기사, 힐러, 사냥꾼, 요정, 마녀) ->  피, 공격력,  방어력 설정

// 이중 해시로 관리하자  -> map< monster(이름) , map < attack, shield > >
// -> 캐릭터도 동일 map < "궁수" , map < 10, 5 >>
// -> 피는 기본 100으로 따로 arraylist나 int[] 배열로 관리해서 공격받으면 마이너스 되도록 구성하자!

// 원래 {{궁수, 피, 공격력, 방어력}, {기사, 피, 공격력, 방어력} 하고 싶긴했는데.. 모르겟음

//(스킬 설정 없이 평타만 갈기도록 구성해봅시다)       -> 캐릭터에서 몬스터공격 메소드 구현