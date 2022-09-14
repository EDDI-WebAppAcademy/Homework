import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_RANDOM_MONSTER,
    REQUEST_CHARACTER_STATUS,
    REQUEST_INVENTORY_ITEM,
    REQUEST_MONSTER_LIST, REQUEST_EXP_EXCHANGE_FROM_SPRING,

} from './mutation-types'
export default {
    // vue에서 [] 라는 연산자는 멤버 접근 연산자라는 특성을 가집니다.
    // 중요한 요소는 아니고 결국 [0]번 멤버, [1]번 멤버라고 표현하면 가독성이 떨어지니
    // REQUEST_DATA_FROM_SPRING이라고 무엇을 하는 녀석인지 명시하는 작업입니다.
    [REQUEST_DATA_FROM_SPRING] (state, passingData) {
        // actions -> mutation -> state에 값 셋팅
        state.springFromVueTestValue = passingData
    },
    [REQUEST_RANDOM_SHOP_ITEM] (state, passingData) {
        state.randomShopItem = passingData
    },
    [REQUEST_MONSTER_LIST] (state, passingData) {
        state.monsterList = passingData
    },
    [REQUEST_RANDOM_MONSTER] (state, passingData) {
        state.randomMonster = passingData
    },
    [REQUEST_CHARACTER_STATUS] (state, passingData) {
        state.characterStatus = passingData
    },
    [REQUEST_INVENTORY_ITEM] (state, passingData) {
        state.myInventory = passingData
    },
    [REQUEST_EXP_EXCHANGE_FROM_SPRING] (state, passingData) {
        state.expExchangeLists = passingData
    }



}