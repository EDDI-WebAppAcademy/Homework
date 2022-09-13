package kr.eddi.demo.controller.homework.eighth;


import kr.eddi.demo.homework.entity.nineth.MonsterGameManager;
import kr.eddi.demo.homework.entity.nineth.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/homework-etc")
public class NinethHomeworkMonsterController {

    private MonsterGameManager monsterGameManager;

    @GetMapping("/monstergame")
    public String MonsterGame(){


        monsterGameManager = new MonsterGameManager();

        monsterGameManager.selectCharacter();
        monsterGameManager.gameStart();

        return "몬스터 게임 시작";



    }


}


/*
컨트롤러  - 플레이어 객체 생성 + 플레이어. 게임 스타트()
라운드 매니저 - 라운드 관리 (총 3라운드로 진행해보자 -> 지정 가능하도록) , 몬스터들 등장
몬스터 클래스 - 몬스터 종류 관리 (랜덤으로 선택됨 , ),  -> 몬스터에서 임의 패기 메소드 구현
캐릭터 클래스 - 캐릭터  종류 관리(마법사, 궁수, 기사, 힐러, 사냥꾼, 요정, 마녀) , 공격력, 피, 기본 방어력 설정
플레이어 클래스 -  ?? 라운드 정보를 갖나?
몬스터 게임매니저 -  캐릭터 배치, 파티구성 기능, 조합은 입력 받기
 */


//방치형 시뮬레이션 게임을 만들어봅시다.
//라운드마다 몬스터들이 등장합니다.          -> 라운드매니저
//몬스터는 플레이어의 캐릭터들을 임의로 팹니다.       -> 몬스터에서 임의 패기 메소드 구현
//플레이어는 캐릭터들을 배치하여 몬스터와 전투를 진행할 수 있습니다. -> 플레이어에서 캐릭터 정보 받아와 배치할수 있게 메소드
//(스킬 설정 없이 평타만 갈기도록 구성해봅시다)       -> 캐릭터에서 몬스터공격 메소드 구현
//파티 구성 멤버는 총 5명으로 제한합니다.             -> 플레이어에서 제한
//조합은 구성하고 싶은대로 구성합니다.                -> 플레이어에서 구성



//방치형 시뮬레이션 게임을 만들어봅시다.
//라운드마다 몬스터들이 등장합니다.
//몬스터는 플레이어의 캐릭터들을 임의로 팹니다.
//플레이어는 캐릭터들을 배치하여 몬스터와 전투를 진행할 수 있습니다.
//(스킬 설정 없이 평타만 갈기도록 구성해봅시다)
//파티 구성 멤버는 총 5명으로 제한합니다.
//조합은 구성하고 싶은대로 구성합니다.
//[출처] class 문제 [ 1 ] (에디로봇아카데미) | 작성자 링크쌤