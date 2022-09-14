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

public class Question9 {
    final int MIN = 2;
    final int MAX = 10;
    final int START = 1;
    final int END = 100;

    @GetMapping("/9")
    public String randomMultipleSum(){
        CustomRandom rand = new CustomRandom();
        int randNum = rand.makeIntCustomRandom(MIN, MAX);
        int sum = 0;
        String str9 = "";
        ArrayList<Integer> randomMultiple = new ArrayList<>(); //randNum의 배수를 담을 공간.

        for (int i = START; i <= END; i++){
            if (i % randNum == 0){
                randNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
                randomMultiple.add(i); //어떤 배수들이 뽑혔는지 확인하고, 총합 구하기 위함.
            }
        }

        for (int i = 0; i < randomMultiple.size(); i++){
            str9 = str9+randomMultiple.get(i)+"<br>";
        }

        for (int i = 0; i < randomMultiple.size(); i++) {
            sum += randomMultiple.get(i); //모든 요소를 더함.
        }

        return "등장한 배수들은 다음과 같고<br>"+str9+"총합은"+sum+"입니다.";
    }
}
