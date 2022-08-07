package kr.eddi.demo.entity.basic.nineth;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
public class LottoCardManager {   // 로또 매니저 역할 - 각 플레이어의 카드 리스트 생성 + 유효한 카드 값인지 체크
    private List<LottoCard> cards;      // 로또 번호 정보 받음 -> cards는 리스트(arraylist)형식의 LottoCard 클래스 타입!!!!***
    private final int LOTTO_CARD_LENGTH = 6;      // 로또 번호는 6자리
    private final int DUPLICATE_LIMITATION = 100; //중복 제한?

    public LottoCardManager(int playerNum) {    // 로또 카드 매니저 생성하면 플레이어번호 받아 생성
        cards = new ArrayList<>(playerNum);      // ArrayList<> integers3 = new ArrayList<>(10); // 뒤 () 생략가능. 쓴다면 초기 용량(Capacity) 설정

        for (int i = 0; i < playerNum; i++) {       // playersize 만큼 반복
            cards.add(new LottoCard());          //-> playersize 만큼 cards 객체에 lottoCard 객체를 생성하여 넣는다.
        }
    }
    //-> (1) 로또카드매니저 객체 생성 (인자: int playerNum)
   //-> (2) cards ={ 0, 1, 2,..} playerNum 만큼 배열 생김
   //-> (3) cards = {lottocard 객체 , lottocard 객체, ...} 배열안에 lottocard 객체 데이터  각각 들어감 -> 100개의 lottocards 객체가 생김
    //-> (4) cards 생성되면 cards에는 int 6개의 number 배열이 생성됨


    public void allocLottoCardNumber() {    // 로또카드넘버 할당 메소드
        int tmpNum;
        int people = cards.size();                  // cards.size = players.size로 100개

        for (int j = 0; j < LOTTO_CARD_LENGTH; j++) {                                              // j = 0, 1, ,, 6
            for (int i = 0; i < people; i++) {                                                     // i = 0, 1, ,,, 100
                if (people > DUPLICATE_LIMITATION) { cards.get(i).generateLottoNumber(j); }   // people 사이즈가 100보다 크면 유효번호 체크 없이 그냥 로또 번호 추첨 진행
                else {
                    do {
                        tmpNum = cards.get(i).generateLottoNumber(j);     // List.get(i)는 값의 저장도 포함됨 !!! 실행과 동시에 cards[i] 배열에 값이 저장되는 것임
                                                                                               // i*j = 600개의 로또넘버 할당됨, cards = {lottocard 객체(number 배열) , lottocard 객체(number 배열), ...}
                                                                                              // j=0, i = 2일 때 tmpNum =  cards[0]에 generate()메소드 적용- lottoCards 객체의 number[2] 값을 넣어줌
                                                                                             // 즉, 첫 반복은 j=0, i = 0 ~ 100 ->  cards[0]의 lottoCards 객체(고정). -> number 배열의 [0]번째 값 추출
                                                                                               // 결론, 첫 반복은 100명의 플레이어의 첫번째 로또번호(number[0])를 생성한 것
                    } while (verifyDuplicateLottoCard(i, j, cards));                           // 유효번호 체크 - do - while(true)문 :
                                                                                               // 무조건 랜덤 번호 생성 -> 조건(유효번호 true인지) 체크: true면 다시 do-while문 실행-> 랜덤번호 생성
                                                                                                  // false 면 다음 순서 i로 반복문 실행
                }
            }
        }
    }


    private Boolean verifyDuplicateLottoCard(int curPersonIdx, int curLottoColumnIdx, List<LottoCard> cards) {  // (플레이어번호, 로또 자릿수 번호, cards 객체)

        if (curPersonIdx == 0) { return false; }                                                            // 만약 첫번째 플레이어면 건너뛰기

        int compareTarget = cards.get(curPersonIdx).getNumbers()[curLottoColumnIdx];   // 비교 타겟 숫자 = cards[플레이어번호 i]- number[자릿수 j] 해당값

        for (int i = 0; i < curPersonIdx; i++) {                                           // 플레이어 번호만큼 반복해라
            int eachNumber = cards.get(i).getNumbers()[curLottoColumnIdx];                   // eachNumber= cards[0,,,100]의 number[자릿수 고정]

            System.out.printf("curPersonIdx: %d, compareTarget: %d, eachNumber: %d\n",              //System.out.printf("출력 서식",출력할 내용); - 형식화된 출력
                    curPersonIdx, compareTarget, eachNumber);

            if (eachNumber == compareTarget) {        // 타겟 숫자와 number 배열 같은 자릿수에 같은 값 존재하면 true 반환
                return true;
            }
        }

        return false;
    }


}