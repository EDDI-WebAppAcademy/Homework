package kr.eddi.demo.controller.vue.homework.rpg;


import kr.eddi.demo.controller.vue.homework.rpg.request.ExchangeExp;
import kr.eddi.demo.controller.vue.homework.rpg.request.RequestEquipItem;
import kr.eddi.demo.homework.entity.rpg.Character;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

//exchangeExpLists
@Slf4j
@RestController
@RequestMapping("/homework")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ExperienceController {

    private String expMsg = "";

    @PostMapping("/exchange-exp")
    public String exchangeExpList(@RequestBody ExchangeExp exchangeExp) {
        log.info("경험치 교환 메소드");
        log.info("데이터 요소 확인: " + exchangeExp.getExchangeExpLists().get(0));
        log.info("전송 데이터 확인: " + exchangeExp);

        exchangeExperience(exchangeExp);


        return expMsg;
    }

    public void exchangeExperience(ExchangeExp exchangeExp) {

        int tmpTotalExchangeExp = 0;

        for (int i = 0; i < exchangeExp.getExchangeExpLists().size(); i++) {
            if (exchangeExp.getExchangeExpLists().get(i) != null) {
                tmpTotalExchangeExp += exchangeExp.getEXCHANGE_EXP_POINT();
                log.info("경험치 교환 널값 아님: " + tmpTotalExchangeExp);
            }
        }

        if (Character.madeCharacterList.get(0).getCurrentLevelBar() >= tmpTotalExchangeExp) {

            for (int i = 0; i < exchangeExp.getExchangeExpLists().size(); i++) {
                if(exchangeExp.getExchangeExpLists().get(i)!= null){
                    Character.madeCharacterList.get(0).setCurrentLevelBar(Character.madeCharacterList.get(0).getCurrentLevelBar()-exchangeExp.getEXCHANGE_EXP_POINT());

                    switch (exchangeExp.getExchangeExpLists().get(i)) {
                        case "hp":
                            exchangeExp.setExchangeHP(exchangeExp.getExchangeHP() + exchangeExp.getHP_MP_INCREMENT());
                            Character.madeCharacterList.get(0).setHp(Character.madeCharacterList.get(0).getHp()+exchangeExp.getExchangeHP());
                            break;
                        case "mp":
                            exchangeExp.setExchangeMP(exchangeExp.getExchangeMP() + exchangeExp.getHP_MP_INCREMENT());
                            Character.madeCharacterList.get(0).setMp(Character.madeCharacterList.get(0).getMp()+exchangeExp.getExchangeMP());
                            break;
                        case "atk":
                            exchangeExp.setExchangeATK(exchangeExp.getExchangeATK() + exchangeExp.getOTHER_STATS_INCREMENT());
                            Character.madeCharacterList.get(0).setAtk(Character.madeCharacterList.get(0).getAtk()+exchangeExp.getExchangeATK());
                            break;
                        case "str":
                            exchangeExp.setExchangeSTR(exchangeExp.getExchangeSTR() + exchangeExp.getOTHER_STATS_INCREMENT());
                            Character.madeCharacterList.get(0).setStr(Character.madeCharacterList.get(0).getStr()+exchangeExp.getExchangeSTR());
                            break;
                        case "intelligence":
                            exchangeExp.setExchangeINT(exchangeExp.getExchangeINT() + exchangeExp.getOTHER_STATS_INCREMENT());
                            Character.madeCharacterList.get(0).setIntelligence(Character.madeCharacterList.get(0).getIntelligence()+exchangeExp.getExchangeINT());
                            break;
                        case "dex":
                            exchangeExp.setExchangeDEX(exchangeExp.getExchangeDEX() + exchangeExp.getOTHER_STATS_INCREMENT());
                            Character.madeCharacterList.get(0).setDex(Character.madeCharacterList.get(0).getDex()+exchangeExp.getExchangeDEX());
                            break;
                        case "def":
                            exchangeExp.setExchangeDEF(exchangeExp.getExchangeDEF() + exchangeExp.getOTHER_STATS_INCREMENT());
                            Character.madeCharacterList.get(0).setDef(Character.madeCharacterList.get(0).getDef()+exchangeExp.getExchangeDEF());
                            break;
                    }
                }

            }
            expMsg = "경험치 교환에 성공했습니다";

        } else {
            expMsg = "교환할 경험치가 부족합니다";
        }
    }
}

