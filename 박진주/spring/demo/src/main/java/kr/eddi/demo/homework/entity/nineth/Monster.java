package kr.eddi.demo.homework.entity.nineth;

import java.util.Map;

public class Monster {


    private final int MONSTER_TYPE_NUM = 7;

    public Map<CharacterType, CharacterStats> characterPower;

}

// 몬스터도 리스트 만들고
// 이중 해시로 관리하자  -> map< monster(이름) , map < attack, shield > >
//-> 캐릭터도 동일 map < "궁수" , map < 10, 5 >>

// 몬스터들이라고 하니까 한 랜덤으로 숫자 정해서 min 1, max 3마리?  -> 한마리라고 가정하자

//라운드마다 몬스터들이 등장합니다.          -> 라운드매니저
//몬스터는 플레이어의 캐릭터들을 임의로 팹니다.       -> 몬스터에서 임의 패기 메소드 구현