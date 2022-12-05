package kr.eddi.demo.entity.vue.thirthyoneth;


import kr.eddi.demo.entity.vue.thirthyoneth.rpgDb.ExpToStatus;

public class ExpChangeManager {

    private final int HP_IDX = ExpToStatus.HP.getStatusId();
    private final int MP_IDX = ExpToStatus.MP.getStatusId();
    private final int ATK_IDX = ExpToStatus.ATK.getStatusId();
    private final int STR_IDX = ExpToStatus.STR.getStatusId();
    private final int DEX_IDX = ExpToStatus.DEX.getStatusId();
    private final int INTELLIGENCE_IDX = ExpToStatus.INTELLIGENCE.getStatusId();
    private final int DEF_IDX = ExpToStatus.DEF.getStatusId();
    private final int VIT_IDX = ExpToStatus.VIT.getStatusId();
    private final int MEN_IDX = ExpToStatus.MEN.getStatusId();




    public void exchangeCharacterStatus(Character character) {

    }


    /**
     * 인덱스 번호에 맞는 스테이터스의 증가 값을 리턴
     * @param idx
     * @return
     */
    /*public int returnCalledStatus(int idx) {
        switch (idx) {
            case HP_IDX -> {
                return ExpToStatus.HP.getValue();
            }
            case MP_IDX -> {
                return ExpToStatus.MP.getValue();
            }
        }
    }*/
}
