import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_MONSTER_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_CHARACTER_FROM_SPRING,
    REQUEST_MANY_RANDOM_MONSTER,
    REQUEST_RANDOM_MONSTER,
    REQUEST_MY_INVENTORY,
    REQUEST_EQUIP_ITEM,
    REQUEST_EXCHANGE_EXP
} from './mutation-types'            //mutation-types 파일에서 가져오는 const 상수

export default {
    [REQUEST_DATA_FROM_SPRING] (state, passingData) {
        state.springFromVueTestValue = passingData
    },

    [REQUEST_RANDOM_SHOP_ITEM] (state, passingData) {
        state.randomShopItem = passingData
    },

    [REQUEST_MONSTER_FROM_SPRING] (state, passingData) {
        state.monsterValue = passingData
    },

    [REQUEST_CHARACTER_FROM_SPRING] (state, passingData) {
        state.characterValue = passingData
    },

    [REQUEST_RANDOM_MONSTER] (state, passingData) {
        state.randomMonsterValue = passingData
    },

    [REQUEST_MANY_RANDOM_MONSTER] (state, passingData) {
        state.manyRandomMonsterValue = passingData
    },
    [REQUEST_MY_INVENTORY] (state, passingData) {
        state.myInventory = passingData
    },
    [REQUEST_EQUIP_ITEM] (state, passingData) {
        state.myEquipItem = passingData
    },
    [REQUEST_EXCHANGE_EXP] (state, passingData) {
        state.exchangeExp = passingData
    },
}
