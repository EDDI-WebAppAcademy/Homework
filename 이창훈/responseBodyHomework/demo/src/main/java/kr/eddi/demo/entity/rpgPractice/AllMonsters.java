package kr.eddi.demo.entity.rpgPractice;

public class AllMonsters {
    private Integer monsterId;
    private String name;
    private Integer hp;
    private Integer exp;
    private Integer dropMoney;

    public AllMonsters(Integer monsterId, String name, Integer hp, Integer exp, Integer dropMoney) {
        this.monsterId = monsterId;
        this.name = name;
        this.hp = hp;
        this.exp = exp;
        this.dropMoney = dropMoney;
    }
}
