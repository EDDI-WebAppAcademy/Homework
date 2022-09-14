package lbk.homework.day0812.javaPrcatice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lbk.homework.day0812.javaPrcatice.Scale.*;

@RestController
@RequestMapping("/run")
public class Run {

    private Scale scale;

    //솔솔 랄라 솔솔 미

    @GetMapping("/scale")
    public String playRun() {

        StringBuilder song = new StringBuilder();
        song.append(acquireScale(Sol));
        song.append(acquireScale(Sol));
        song.append(acquireScale(La));
        song.append(acquireScale(La));
        song.append(acquireScale(Sol));
        song.append(acquireScale(Sol));
        song.append(acquireScale(Mi));

        System.out.println(song.toString());
        return song.toString();
    }





}
