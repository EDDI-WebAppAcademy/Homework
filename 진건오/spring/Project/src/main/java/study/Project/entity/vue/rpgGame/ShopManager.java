package study.Project.entity.vue.rpgGame;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
public class ShopManager {

    private String name;
    private Integer price;
    private String description;
    private Integer atk;
    private String recover;

    public ShopManager(String name, Integer price, String description, Integer atk) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.atk = atk;
    }

    public ShopManager(String name, Integer price, String description, String recover) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.recover = recover;
    }
}
