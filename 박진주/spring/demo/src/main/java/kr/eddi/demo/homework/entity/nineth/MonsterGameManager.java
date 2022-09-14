package kr.eddi.demo.homework.entity.nineth;

import kr.eddi.demo.entity.basic.twelveth.Pattern;
import kr.eddi.demo.entity.basic.utility.basic.twelveth.UserInput;

import java.util.ArrayList;
import java.util.List;

public class MonsterGameManager {

    private final int CHARACTER_NUM = 5;

    private final int FINAL_ROUND = 3;
    public List<String> partyCharacters;      // 유저가 선택한 파티원 리스트
    public List<String> characterTypes = new ArrayList<>();

    public MonsterGameManager(){

        Player player = new Player();
    }


    public void gameStart(){

        // 실제 게임 시작하도록 라운드마다 공격진행되게

        RoundManager roundManager = new RoundManager();

        do{
            roundManager.roundStart();

        } while (isGameFinish()); // 라운드가 3라운드 이상이 되면 false가 되서 게임 종료

    }

    // 플레이어가 파티 구성하도록 입력받기 메소드
    public void selectCharacter(){

        partyCharacters = new ArrayList<>(CHARACTER_NUM);  // 유저 입력받는 캐릭터 저장할 배열
     //   CharacterType characterType = CharacterType.궁수;


        for (CharacterType characterType: CharacterType.values()){
            characterTypes.add(String.valueOf(characterType));
        }

        for (int i = 0; i < CHARACTER_NUM; i++) {

            System.out.println(characterTypes);
            System.out.println(i+1+"번째 배치할 캐릭터 번호를 입력해주세요: ");
            UserInput.inputIntKeyBoard();

            makeParty(UserInput.getSelectedNumber());     // 파티원 배열에 입력값 넣어줌

            System.out.println(i+1+"번째 파티원으로 " + UserInput.getSelectedNumber()+"번째 캐릭터를 선택하셨습니다.");

            // 인덱스 UserInput.getSelectedNumber()를 통해 선택되는 캐릭터 구성되는 makeParty() 만들기

            //캐릭터 클래스에 있는 캐릭터 배열 중 인텍스 입력 받기
        }
    }

    // 입력받은 캐릭터로 파티 구성 저장
    public void makeParty(int selectedNumber){

        partyCharacters.add(characterTypes.get(selectedNumber));
        System.out.println("파티원: " + partyCharacters);

    }


    public boolean isGameFinish(){
        boolean finish = true;
        if(RoundManager.currentRound > FINAL_ROUND){
            finish = false;
        }
        return finish;
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