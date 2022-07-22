package kr.eddi.demo.controller.homework.second;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;



@Slf4j
@Controller


public class AverageExam {

    @ResponseBody
    @GetMapping("/homework2")
    public String pointAverage(){



        int[] pointRan = new int[30];
        for(int i=0; i<30; i++){
            pointRan[i]= (int) (Math.random()*(100-60+1))+60;
        }

        int pointSum=0;

        for(int j=0; j<30; j++){
            pointSum=pointSum+pointRan[j];
        }

        int pointAverage = pointSum / pointRan.length;

        return "평균 : pointAverage ";
    }
}

