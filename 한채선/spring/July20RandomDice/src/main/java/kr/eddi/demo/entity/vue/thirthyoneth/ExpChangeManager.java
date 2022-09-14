package kr.eddi.demo.entity.vue.thirthyoneth;

import kr.eddi.demo.entity.vue.thirthyoneth.rpgDb.ExpToStatus;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class ExpChangeManager {

    private List<ExpChangeStatus> exchangeExpList;

    public ExpChangeManager() {
        buildExpChangeListDB();
    }

    public void buildExpChangeListDB () {
        exchangeExpList = new ArrayList<>();

        //hp
        exchangeExpList.add(new ExpChangeStatus(
                ExpToStatus.EXP_TO_HP.getStatusName(),
                ExpToStatus.EXP_TO_HP.getValue()));
        //mp
        exchangeExpList.add(new ExpChangeStatus(
                ExpToStatus.EXP_TO_MP.getStatusName(),
                ExpToStatus.EXP_TO_MP.getValue()));
        //atk
        exchangeExpList.add(new ExpChangeStatus(
                ExpToStatus.EXP_TO_ATK.getStatusName(),
                ExpToStatus.EXP_TO_ATK.getValue()));
        //def
        exchangeExpList.add(new ExpChangeStatus(
                ExpToStatus.EXP_TO_DEF.getStatusName(),
                ExpToStatus.EXP_TO_DEF.getValue()));
        //str
        exchangeExpList.add(new ExpChangeStatus(
                ExpToStatus.EXP_TO_STR.getStatusName(),
                ExpToStatus.EXP_TO_STR.getValue()));
        //intelligence
        exchangeExpList.add(new ExpChangeStatus(
                ExpToStatus.EXP_TO_INTELLIGENCE.getStatusName(),
                ExpToStatus.EXP_TO_INTELLIGENCE.getValue()));
        //dex
        exchangeExpList.add(new ExpChangeStatus(
                ExpToStatus.EXP_TO_DEX.getStatusName(),
                ExpToStatus.EXP_TO_DEX.getValue()));
        //vit
        exchangeExpList.add(new ExpChangeStatus(
                ExpToStatus.EXP_TO_VIT.getStatusName(),
                ExpToStatus.EXP_TO_VIT.getValue()));
        //men
        exchangeExpList.add(new ExpChangeStatus(
                ExpToStatus.EXP_TO_MEN.getStatusName(),
                ExpToStatus.EXP_TO_MEN.getValue()));
    }
}
