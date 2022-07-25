package kr.eddi.demo.controller.homework.Homework0722;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/Homework4")


public class Question2 {

    // [문제은행 2-2]


            int[] num = new int[20];

            public int Num() {
                num[0] = 1;
                num[1] = 1;

                for (int i = 2; i < num.length; i++) {
                    num[i] = num[i - 1] + num[i - 2];
                }

                return num[19];


        }
    }
