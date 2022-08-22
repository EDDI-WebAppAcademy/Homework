package kr.eddi.demo.controller.homework.sixth;

public class DoubleDice {

    public static void main(String[] args) {

        int firstDice = (int)(Math.random()*6) + 1 ;
        int secondDice = (int)(Math.random()*6) + 1 ;

        if((firstDice + secondDice) == 4) {
            System.out.println( "첫번 째 주사위의 수 : "+ firstDice + "두번째 주사위의 수 :"+ secondDice + "주사위의 숫자 4가 떳기 때문에 게임이 종료됩니다." );
        } else if ((firstDice + secondDice) == 3) {
            System.out.println( "첫번 째 주사위의 수 : "+ firstDice + "두번째 주사위의 수 :"+ secondDice + "주사위의 숫자 3이 떳기 점수를 3점씩 빼앗아 옵니다." );
        } else if ((firstDice + secondDice) == 5) {
            System.out.println( "첫번 째 주사위의 수 : "+ firstDice + "두번째 주사위의 수 :"+ secondDice + "주사위의 숫자 5가 떳기 점수를 2점씩 나눠줍니다." );
        } else if ((firstDice + secondDice == 1)) {
            System.out.println( "첫번 째 주사위의 수 : "+ firstDice + "두번째 주사위의 수 :"+ secondDice + "주사위의 숫자 5가 떳기 점수를 2점씩 나눠줍니다." );
        } else
            System.out.println("게임을 종료 합니다.");
    }
}
