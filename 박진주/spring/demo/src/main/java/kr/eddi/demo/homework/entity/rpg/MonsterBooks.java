package kr.eddi.demo.homework.entity.rpg;

public enum MonsterBooks {

    슬라임(1, "슬라임", 50, 10, 5),
    고블린(2, "고블린", 100, 20, 10),
    놀(3,"놀",200, 40, 20),
    멧돼지(4,"멧돼지", 400, 100, 20),
    스켈레톤(5,"스켈레톤", 350, 90, 10),
    오크(6,"오크", 550, 150, 40),
    홉고블린(7,"홉고블린",650, 280, 50);


    public final int ID;
    public final String NAME;
    public final int HP;
    public final int EXP;
    public final int DROP_MONEY;

    private MonsterBooks(int ID, String NAME, int HP, int EXP, int DROP_MONEY){
        this.ID = ID;
        this.NAME = NAME;
        this.HP = HP;
        this.EXP = EXP;
        this.DROP_MONEY = DROP_MONEY;
    }

}

//monsterBooks: [
// { monsterId: 1, name: '슬라임', hp: 50, exp: 10, dropMoney: 5 },
// { monsterId: 2, name: '고블린', hp: 100, exp: 20, dropMoney: 10 },
// { monsterId: 3, name: '놀', hp: 200, exp: 40, dropMoney: 20 },
// { monsterId: 4, name: '멧돼지', hp: 400, exp: 100, dropMoney: 20 },
// { monsterId: 5, name: '스켈레톤', hp: 350, exp: 90, dropMoney: 10 },
// { monsterId: 6, name: '오크', hp: 550, exp: 150, dropMoney: 40 },
// { monsterId: 7, name: '홉고블린', hp: 650, exp: 180, dropMoney: 50 },
// { monsterId: 8, name: '스켈레톤 아처', hp: 300, exp: 150, dropMoney: 50 },
// { monsterId: 9, name: '트롤', hp: 800, exp: 200, dropMoney: 80 },
// { monsterId: 10, name: '좀비', hp: 350, exp: 90, dropMoney: 50 },
// { monsterId: 11, name: '고블린 매지션', hp: 700, exp: 500, dropMoney: 300 },
// { monsterId: 12, name: '오우거', hp: 1000, exp: 250, dropMoney: 50 },
// { monsterId: 13, name: '고스트', hp: 750, exp: 300, dropMoney: 1 },
// { monsterId: 14, name: '골렘', hp: 2000, exp: 400, dropMoney: 100 },
// { monsterId: 15, name: '와이번', hp: 3500, exp: 500, dropMoney: 150 },
// { monsterId: 16, name: '리치', hp: 2000, exp: 1000, dropMoney: 500 },
// { monsterId: 17, name: '스켈레톤 기사', hp: 2500, exp: 700, dropMoney: 100 },
// { monsterId: 18, name: '웨어울프', hp: 5000, exp: 1000, dropMoney: 700 },
// { monsterId: 19, name: '미노타우루스', hp: 10000, exp: 1500, dropMoney: 1000 },
// { monsterId: 20, name: '드레이크', hp: 20000, exp: 5000, dropMoney: 50000 },
// { monsterId: 21, name: '죽음의 군주', hp: 1000000, exp: 200000, dropMoney: 1000000 },
// { monsterId: 9999, name: '하이퍼 메탈 슬라임', hp: 1000, exp: 5000000, dropMoney: 10000000 }
// ],