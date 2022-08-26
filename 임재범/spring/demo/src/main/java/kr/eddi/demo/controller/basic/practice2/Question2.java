package kr.eddi.demo.controller.basic.practice2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.eddi.demo.entity.basic.practice2.Array;

@Slf4j
@RestController
@RequestMapping("/practice2")


public class Question2 {

    @GetMapping("/2")
    public String fibonacci(){
        Array array = new Array(20);
        int[] arr = array.getArr();

        //int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;

        for(int i=2; i<20; i++){
            arr[i] = arr[i-2]+arr[i-1];
        }
        return "피보나치 수열의 20번째 항은 "+arr[19]+"입니다.";
    }
}
