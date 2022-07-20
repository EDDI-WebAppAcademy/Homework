package homework.demo.homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class randomNUm {

    @GetMapping("/")
    public int ranNum(){
        int max = 6;
        int min = 1;
        int num = (int)(Math.random()*(max - min + 1)+min);


        return num;
    }
}
