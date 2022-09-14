package kr.eddi.demo.controller.basic.practice2;

import kr.eddi.demo.entity.basic.practice2.Array;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/practice2")

public class Question3 {

   @GetMapping("/3")
    public String narayana(){
      Array array = new Array(25);
      int[] arr = array.getArr();
       arr[0] = 1;
       arr[1] = 1;
       arr[2] = 1;
       for(int i=3; i<arr.length; i++){
           arr[i] = arr[i-1]+arr[i-3];
       }
       return "이 수열의 25번째 항은 " +arr[24]+"입니다.";


   }
}
