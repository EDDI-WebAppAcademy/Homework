package lbk.homework.day0902.vue.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RpgPlayer {

    int level = 1;
    int hp = 50;
    int mp = 30;
    int money = 0;
    int currentExpBar = 0;
    int totalExpBar = 0;
}
