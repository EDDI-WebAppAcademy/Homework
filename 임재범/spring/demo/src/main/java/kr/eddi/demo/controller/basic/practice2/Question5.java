package kr.eddi.demo.controller.basic.practice2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.eddi.demo.entity.basic.practice2.Array;

@Slf4j
@RestController
@RequestMapping("/practice2")

public class Question5 {
    @GetMapping("/5")
    public String evenNumber(){
        Array arr = new Array(100); //100칸짜리 배열 arr 생성
        arr.OneToHundred(); //arr에 1~100까지 숫자 저장
        int[] arr5 = arr.getArr();
        String str5=""; //이 string에 숫자를 가산해감. 마지막에 str리턴해서 끝낼거임.

        for(int i=0; i<arr5.length; i++){
            if(arr5[i]%2==0){
                str5 = str5+arr5[i]+"<br>"; //짝수인 항들만 가산해감.
            }
        }

        return str5;
    }

}
