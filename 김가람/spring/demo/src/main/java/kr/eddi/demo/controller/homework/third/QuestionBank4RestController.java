package kr.eddi.demo.controller.homework.third;

import kr.eddi.demo.entity.homework.third.TwoDimensionalArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/homework4")
public class QuestionBank4RestController {
    private final int TWO = 2;

    @GetMapping("/print-array")
    public String printArray() {
        log.info("2차원 배열을 출력합니다.");

        TwoDimensionalArray twoDimensionalArray = new TwoDimensionalArray(TWO, TWO);

        return TWO + "차원 배열을 출력합니다.<br>"
                + twoDimensionalArray.makeTwoDimensionalArray();
    }
}
