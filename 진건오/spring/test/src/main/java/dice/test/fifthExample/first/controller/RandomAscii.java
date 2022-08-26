package dice.test.fifthExample.first.controller;

import dice.test.fifthExample.third.entity.CreateRandom;
import dice.test.fifthExample.first.entity.DecimalAsciiConversion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class RandomAscii {
    private int randomAsciiDecimal;
    private final int MAX_RANGE = 122;
    private final int MIN_RANGE = 65;

    @ResponseBody
    @GetMapping("/change-ascii")
    public String printRandomAscii() {
        randomAsciiDecimal = CreateRandom.makeToCreateRandom(MAX_RANGE, MIN_RANGE);

        DecimalAsciiConversion decimalAsciiConversion =
                new DecimalAsciiConversion(randomAsciiDecimal);

        return decimalAsciiConversion.checkAsciiConversion();
    }
}
