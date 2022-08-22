package kr.eddi.demo.controller.basic.practice2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.eddi.demo.entity.basic.practice2.TimeTable;

@Slf4j
@RestController
@RequestMapping("/practice2")

public class Question4 {
    @GetMapping("/4")
    public String timetable(){
        TimeTable timetable = new TimeTable(7);
        int[][] arr = timetable.getArr(); //arr은 2차원 배열이고 7단이 담겨있다.
        String[] str = new String[9];

        for(int i=0; i<9; i++){
           str[i] = arr[i][0]+" x "+arr[i][1]+" = "+arr[i][2]; //행렬에 담긴 구구단을 7x2=14와 같은 형태로 만듦
        }
        String str2 = str[0];

        for(int j=1; j<9; j++){
            str2 = str2 + "<br>" + str[j]; //7x1=7
                                           //7x2=14와 같이 만들기 위해 누산.
        }

        return str2;
    }
    }


