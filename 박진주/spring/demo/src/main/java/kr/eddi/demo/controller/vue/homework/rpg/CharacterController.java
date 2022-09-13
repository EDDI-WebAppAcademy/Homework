package kr.eddi.demo.controller.vue.homework.rpg;

import kr.eddi.demo.homework.entity.rpg.Character;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/homework")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CharacterController {

    public List<Character> characterStatusList = new ArrayList<>();


    @GetMapping("/monstergame-character")
    public List<Character> characterData(){
        log.info("캐릭터 데이터 전송 메소드 실행");

 //       characterStatus();
       makeCharacterList();

       return Character.madeCharacterList;

    }

    public void characterStatus(){
        characterStatusList.add(new Character(1, 50, 30, 0, 10, 10, 10, 10, 10, 10, 10, 0, 10, 2000, 1000, "모험가"));
    }

    public void makeCharacterList(){
        if(characterStatusList.size()== 0){
            characterStatus();
            Character.madeCharacterList.addAll(characterStatusList);
        }
        log.info("만들어진 캐릭터 리스트의 money: " +  Character.madeCharacterList.get(0).getMoney());
        log.info("만들어진 캐릭터 리스트의 직업: " +  Character.madeCharacterList.get(0).getCurrentJob());
        log.info("만들어진 캐릭터 리스트의 사이즈: " +  Character.madeCharacterList.size());
    }
}
