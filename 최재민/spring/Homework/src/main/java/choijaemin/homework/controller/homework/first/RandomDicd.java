package choijaemin.homework.controller.homework.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomDicd {

    @GetMapping("/")
    public int dice(){
        int max = 6;
        int min = 1;
        int num = (int)(Math.random()*(max - min + 1)+min);


        return num;
    }
}
