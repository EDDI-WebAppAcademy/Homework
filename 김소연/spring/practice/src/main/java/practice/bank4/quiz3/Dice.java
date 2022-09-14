package practice.bank4.quiz3;

class Dice {
    private int face;

    void rollDice(){
        face = (int)(Math.random()*6)+1;
    }

    void checkDice() {
        System.out.println("주사위의 값은 : " + face);
    }

}
