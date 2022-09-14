package kr.eddi.demo.entity.vue.thirthyoneth;


import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ExpChangeStatus {


    private String statusName;
    private int value;

    public ExpChangeStatus(String statusName, int value) {
        this.statusName = statusName;
        this.value = value;
    }
}
