package kr.eddi.demo.controller.basic.practice2;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.eddi.demo.entity.basic.practice2.Array;

@Slf4j
@RestController
@RequestMapping("/practice2")

public class Question8 {
    @GetMapping("/8")
    public String multipleofn(){

        CustomRandom rand = new CustomRandom();
        int num = rand.makeIntCustomRandom(2, 10);

        Array arr = new Array(100);
        arr.OneToHundred();
        int[] arr8 = arr.getArr();

        String str8 = "";

        for(int i=0; i<arr8.length; i++){
            if(arr8[i]%num==0){
                str8 = str8 + arr8[i]+"<br>";
            }
        }
        return "선택된 숫자는 "+num+"입니다."+"<br>"+str8;
    }
}
