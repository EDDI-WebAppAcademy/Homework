package kr.eddi.demo.homework.entity.sixth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {


    public int[] playerNum = new int[5]; // 플레이어 넘버 저장

    public int[] join = {0,0,0,0,0};  // 참가여부 0으로 디폴트
    public Player() {
    }
}



// 몇번째 판인지
//몇명 게임인지
//

//1. 주사위 게임을 만들어보자!

//총 2개의 주사위를 굴릴 수 있다.
//첫 번째 주사위를 굴려서 짝수가 나왔다면 주사위를 한 번 더 굴릴 수 있다.
//새롭게 한 번 더 굴리는 주사위에는 특수 기능들이 달려 있다.
//숫자 4가 나오는 경우 즉시 게임 오버된다.
//숫자 3이 나오는 경우엔 친구들 주사위에서 점수를 3점씩 뺏어올 수 있다.
//숫자 5가 나오는 경우엔 자신의 점수를 2점씩 친구들에게 나눠줘야 한다.
//숫자 1의 경우엔 모두 다 함께 -2점씩 감점된다.
//* 예외 사항으로 이미 0점인 친구 혹은 아직 주사위를 굴리지 않았다면 음수값을 가지지 않고 0점을 유지한다.
//이 상태에서 주사위의 합산값이 높은 사람이 이기도록 게임을 만들어보자!
//[출처] Java 문제 은행 [ 1 ] (에디로봇아카데미) | 작성자 링크쌤