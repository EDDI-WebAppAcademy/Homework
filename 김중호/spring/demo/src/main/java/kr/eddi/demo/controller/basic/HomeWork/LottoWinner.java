package kr.eddi.demo.controller.basic.HomeWork;

public class LottoWinner {

    public static void main(String[] args) {
        int[] num = new int[6];
        int i = 0;
        while(i < 6) {
            num[i] = (int)(Math.random() * 98 + 1);
            i++;
        }
        for(int j = 0; j < 6; j++) {
            for(int v = 0; v < 6; v++) {
                if(j == v) {
                    continue;
                }
                else if (num[v] == num[j]) {
                    num[j] = (int) (Math.random() * 98 + 1);
                }
            }
        }
        for(int k=0; k < 6; k++) {
            for(int j=k+1; j < 6; j++) {
                if(num[k] > num[j]) {
                    int tmp = num[k];
                    num[k] = num[j];
                    num[j] = tmp;
                }
            }
        }
        for(int j = 0; j < 6; j++) {
            System.out.print(num[j] + "  ");
        }
    }
}