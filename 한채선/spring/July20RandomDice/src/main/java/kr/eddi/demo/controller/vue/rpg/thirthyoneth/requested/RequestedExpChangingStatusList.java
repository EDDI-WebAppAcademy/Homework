package kr.eddi.demo.controller.vue.rpg.thirthyoneth.requested;


import kr.eddi.demo.entity.vue.thirthyoneth.ExpChangeStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@NoArgsConstructor
public class RequestedExpChangingStatusList {

    private List<ExpChangeStatus> changingExpStatusList;

    public RequestedExpChangingStatusList(List<ExpChangeStatus> changingExpStatusList) {
        this.changingExpStatusList = changingExpStatusList;
    }

    public int calcTotalExpToChangeStatus() {
        int totalExp = changingExpStatusList.size() * 100000000;
        return totalExp;
    }
}
