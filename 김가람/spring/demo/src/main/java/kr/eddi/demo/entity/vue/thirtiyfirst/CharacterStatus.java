package kr.eddi.demo.entity.vue.thirtiyfirst;

import lombok.Getter;

@Getter
public class CharacterStatus {
    private Integer level = 1;
    private Integer hp = 50;
    private Integer mp = 30;
    private Integer itemAtk = 0;
    private Integer defaultAtk = 10;
    private Integer atk = 10;
    private Integer str = 10;
    private Integer intelligence = 10;
    private Integer dex = 10;
    private Integer vit = 10;
    private Integer def = 10;
    private Integer men = 0;
    private Integer totalLevelBar = 10;
    private Integer currentLevelBar = 0;
    private Integer money = 0;
    private String currentJob = "모험가";

}
