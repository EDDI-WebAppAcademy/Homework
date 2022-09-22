package kr.eddi.demo.controller.seventh;

import kr.eddi.demo.entity.seventh.LottoPlayer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/seventh")
public class SeventhHomeworkRestController {

    private final int DEFAULT_PLAYER_NUM = 100;


    private List<LottoPlayer> players;
    private int playerNum;
    private long prize = 10000000000L;

    @GetMapping("/homework7")
    public String lottoSystemPlaying() {


        return checkWinner();
    }



    public String checkWinner(){


        return "";
    }

}
