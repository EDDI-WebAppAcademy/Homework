import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_MY_INVENTORY,
    REQUEST_MANY_MONSTERS,
    REQUEST_DEFAULT_MONSTERS,
    REQUEST_CHARACTER_STATUS,
    REQUEST_EXP_TRADE_SYSTEM
} from './mutation-types'

export default {
    [REQUEST_DATA_FROM_SPRING] (state, passingData) {
        state.springFromVueTestValue = passingData
    },
    [REQUEST_RANDOM_SHOP_ITEM] (state, passingData) {
        state.randomShopItem = passingData
    },
    [REQUEST_MY_INVENTORY] (state, passingData) {
        state.myInventory = passingData
    },
    [REQUEST_MANY_MONSTERS] (state, passingData) {
        state.manyMonsters = passingData
    },
    [REQUEST_DEFAULT_MONSTERS] (state, passingData) {
        state.defaultMonsters = passingData
    },
    [REQUEST_CHARACTER_STATUS] (state, passingData) {
        state.characterStatus = passingData
    },
    [REQUEST_EXP_TRADE_SYSTEM] (state, passingData) {
        state.expTradeSystem = passingData
    },

}