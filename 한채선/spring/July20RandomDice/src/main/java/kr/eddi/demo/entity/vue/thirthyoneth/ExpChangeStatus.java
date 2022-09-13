package kr.eddi.demo.entity.vue.thirthyoneth;


import lombok.Getter;

@Getter
public class ExpChangeStatus {


    private String statusName;
    private int value;

    public ExpChangeStatus(String statusName, int value) {
        this.statusName = statusName;
        this.value = value;
    }
}
