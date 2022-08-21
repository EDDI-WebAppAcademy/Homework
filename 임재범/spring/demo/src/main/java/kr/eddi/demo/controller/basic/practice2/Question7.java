package kr.eddi.demo.controller.basic.practice2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.eddi.demo.entity.basic.practice2.Array;

@Slf4j
@RestController
@RequestMapping("/practice2")

public class Question7 {
    @GetMapping("/7")
    public String multipleOf4(){
        Array arr = new Array(100);
        arr.OneToHundred();
        int[] arr7 = arr.getArr();
        int sum = 0;

        for(int i=0; i<arr7.length; i++){
            if(arr7[i]%4==0){
                sum = sum + arr7[i];
            }
        }
        return "100이하 4의 배수의 합은 "+sum+"입니다.";
    }
}
