package kr.eddi.demo.entity.homework.fourth;

public class Gugudan {

    private int num;

    public Gugudan(int gugudanNum) {
        this.num = gugudanNum;
    }

    public String valueGugudan() {
        String msg = "";
        for (int i = num; i <= num; i++) {
            for (int j = 1; j <= 9; j++) {
                msg += i + " X " + j + " = " + i * j + ", ";
            }
        }
        return msg;
    }
}
