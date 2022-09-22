package kr.eddi.demo.entity.vue.thirthyoneth;

import kr.eddi.demo.controller.vue.rpg.thirthyoneth.requested.RequestedBuyItem;
import lombok.Getter;

import java.util.List;

@Getter
public class CharacterManager {

    private Character character;

    public void makeCharacter(String name, String job) {
        character = new Character(name);
        character.setJob(job);
    }

    public void addItemToInventory(RequestedBuyItem requestedBuyItem) {
        character.getCharacterInventory().addItems(requestedBuyItem.getItemList());
    }

    public void calcMoney(int totalPrice) {
        int characterMoney = character.getMoney();
        characterMoney -= totalPrice;
        character.setMoney(characterMoney);
    }

    public void calcExp(int totalExp) {
        int characterExp = character.getCurrentLeverBar();
        characterExp -= totalExp;
        character.setCurrentLeverBar(characterExp);
    }


}