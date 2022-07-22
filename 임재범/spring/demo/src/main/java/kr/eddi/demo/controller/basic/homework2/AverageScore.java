package kr.eddi.demo.controller.basic.homework2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/homework2")
public class AverageScore {

    @ResponseBody
    @GetMapping("")
    public String whatIsTheAverageScore(){
        log.info("whatIsTheAverageScore() 메소드 작동!");


        int sum=0; //30명의 합산점수가 담길 공간 초기화.

        int[] arr = new int[30]; //점수를 담을 30칸짜리 배열 생성
        for(int i=0; i<30; i++){
            arr[i]= (int) (Math.random()*40)+60; //60점이상 100점이하의 점수할당. 총30번 실행.
        }

        for(int j=0; j<30; j++){
            sum=sum+arr[j]; //30명의 학생 점수 합산해서 sum에 저장.
        }
        int avg = sum/30; //30으로 나누어서 평균점수 계산

        return "오후반 30명 학생들의 평균점수는 : "+avg+"입니다.";
    }

}
