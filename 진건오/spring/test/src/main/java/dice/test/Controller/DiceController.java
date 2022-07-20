package dice.test.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiceController {

    @GetMapping("/homework1")
    public String dice() {
        int dice = (int)((Math.random()) * 6 ) + 1;
        String str = Integer.toString(dice);

        return "주사위 수: " + str;
    }
}
