package kr.eddi.demo.controller.basic.practice2;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.eddi.demo.entity.basic.practice2.Array;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/practice2")

public class Question10 {
    final int MIN = 2;
    final int MAX = 10;
    final int START = 1;
    final int END = 100;
    @GetMapping("/10")
    public String randomMovement(){
        CustomRandom rand = new CustomRandom();
        int randNum = rand.makeIntCustomRandom(MIN, MAX);
        int sum = 0;
        String str10 = "";
        ArrayList<Integer> randomMovementNum = new ArrayList<>(); //randNum만큼 이동했을때 거기에 누가있었는지 쓸 공간.
        for (int i = START; i <= END; i+=randNum){
            randomMovementNum.add(i);
            randNum = rand.makeIntCustomRandom(MIN, MAX);//다시 랜덤한 숫자
        }

        for (int i = 0; i < randomMovementNum.size(); i++){
            str10 = str10+randomMovementNum.get(i)+"<br>";
        }

        for (int i = 0; i < randomMovementNum.size(); i++) {
            sum += randomMovementNum.get(i); //모든 요소를 더함.
        }

        return "등장한 수들은 다음과 같고<br>"+str10+"총합은"+sum+"입니다.";
    }

}
