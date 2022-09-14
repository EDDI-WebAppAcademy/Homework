package kr.eddi.demo.homework.entity.nineth;

public class PlayerManager {


    public String attackPriority(){



        // 플레이어, 몬스터
        // 랜덤 다이스 호출 값 저장
        // 뭐가 더 큰지 비교

        return "Player or Monster";
    }


    public void fight(String PriorityWinner){   // 실제 공격주고 받아서 피 달게 함-> player manager

        switch(PriorityWinner) {
            case "Player":
                // 플레이어 먼저 공격력 높은 캐릭터가 공격

            case "Monster":
                // 몬스터가 먼저 랜덤으로 캐릭터 5개중에 선택하여 패기
        }

    }


}
