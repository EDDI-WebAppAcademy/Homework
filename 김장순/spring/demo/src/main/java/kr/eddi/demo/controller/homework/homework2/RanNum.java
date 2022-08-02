package kr.eddi.demo.controller.homework.homework2;

import java.util.Random;

public class RanNum {
    private int total;
    private int avg;
    /*private HashMap<String,Integer> map = new HashMap<>();*/

   /* public int calAvg() {
        for (int i = 0; i < 30; i++) {
            total += ranNum();
            map.put("학생"+(i+1),ranNum());
        }
        avg = total / 30;
        return avg;
    }*/

    public int ranNum() {
        int maxP = 100;
        int passP = 60;
        int ran = new Random().nextInt(maxP - passP + 1) + passP;
        return ran;
    }
    /*public void showMap(){
        Iterator<String> keys = map.keySet().iterator();
        while (keys.hasNext()){
            String key = keys.next();
            System.out.println(key + ": "+ map.get(key));
        }*/
}



