package lbk.homework.day0917.makeGame.controller;

import lbk.homework.day0917.makeGame.entity.Character;
import lbk.homework.day0917.makeGame.entity.CharacterStatus;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Getter
@ToString
@RestController
@RequestMapping("/2nd")
@CrossOrigin(origins="http://localhost:8080", allowedHeaders = "*")

public class CharacterController {

    //캐릭터 생성
    private Character character= new Character();

    @GetMapping("/response-character-status")
    public CharacterStatus responseCharacterStatus() {
        // 스테이터스 데이터 전송
        return character.getCharacterStatus();
    }
}