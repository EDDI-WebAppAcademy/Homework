package kr.eddi.demo.controller.basic.practice2;



import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.eddi.demo.entity.basic.practice2.Array;

@Slf4j
@RestController
@RequestMapping("/practice2")

public class Question6 {
    @GetMapping("/6")
    public String multipleOf3(){
        Array arr = new Array(100);
        arr.OneToHundred();
        int[] arr6 = arr.getArr(); //1에서 100까지의 숫자가 저장된 배열 arr6
        String str6="";

        for(int i=0; i<arr6.length; i++){
            if(arr6[i]%3==0){
                str6 = str6+arr6[i]+"<br>"; //3의배수만 가산해감. <br>로 개행까지.
            }
        }

        return str6;
    }
}
