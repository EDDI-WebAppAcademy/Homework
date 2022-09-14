package kr.eddi.homework.entity.fifth;

import lombok.Getter;

@Getter
public class Gugudan {
    private int dan;

    public Gugudan(int dan){
        this.dan = dan;
    }


    public void printGugudan(int dan) {
        if(dan >= 1){
            makeGugudan();
        }else{
            System.out.println("잘못된 정보입니다!");
        }
    }

    public String makeGugudan() {
        final int start = 1;
        final int end = 9;

        String msg = "";
        for (int i = start; i <= end; i++) {
            msg += dan + " * "+ i + " = " + (dan * i) +"<br>";
        }
        return msg;
    }

}
