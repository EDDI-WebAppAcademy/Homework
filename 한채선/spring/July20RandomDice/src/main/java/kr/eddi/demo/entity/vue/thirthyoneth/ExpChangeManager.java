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
        exchangeExpList.add(new ExpChangeStatus(ExpToStatus.EXP_TO_HP.getStatusName(), ExpToStatus.EXP_TO_HP.getValue()));
        exchangeExpList.add(new ExpChangeStatus(ExpToStatus.EXP_TO_MP.getStatusName(), ExpToStatus.EXP_TO_MP.getValue()));
        exchangeExpList.add(new ExpChangeStatus(ExpToStatus.EXP_TO_ATK.getStatusName(), ExpToStatus.EXP_TO_ATK.getValue()));
        exchangeExpList.add(new ExpChangeStatus(ExpToStatus.EXP_TO_DEF.getStatusName(), ExpToStatus.EXP_TO_DEF.getValue()));
        exchangeExpList.add(new ExpChangeStatus(ExpToStatus.EXP_TO_STR.getStatusName(), ExpToStatus.EXP_TO_STR.getValue()));
        exchangeExpList.add(new ExpChangeStatus(ExpToStatus.EXP_TO_INTELLIGENCE.getStatusName(), ExpToStatus.EXP_TO_INTELLIGENCE.getValue()));
        exchangeExpList.add(new ExpChangeStatus(ExpToStatus.EXP_TO_DEX.getStatusName(), ExpToStatus.EXP_TO_DEX.getValue()));
        exchangeExpList.add(new ExpChangeStatus(ExpToStatus.EXP_TO_VIT.getStatusName(), ExpToStatus.EXP_TO_VIT.getValue()));
        exchangeExpList.add(new ExpChangeStatus(ExpToStatus.EXP_TO_MEN.getStatusName(), ExpToStatus.EXP_TO_MEN.getValue()));
    }
}
