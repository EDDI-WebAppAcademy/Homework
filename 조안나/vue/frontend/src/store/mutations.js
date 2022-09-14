import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_RANDOM_MONSTERS_LIST,
    REQUEST_CHARACTER_STATUS_LIST,
    REQUEST_MY_INVENTORY, DAMAGED_MONSTERS_LIST,
} from './mutation-types'

export default {
    [REQUEST_DATA_FROM_SPRING] (state, passingData) {
        state.springFromVueTestValue = passingData
    },
    [REQUEST_RANDOM_SHOP_ITEM] (state, passingData) {
        state.randomShopItem = passingData
    },
    [REQUEST_RANDOM_MONSTERS_LIST] (state, passingData) {
        state.randomMonstersList = passingData
    },
    [REQUEST_CHARACTER_STATUS_LIST] (state, passingData) {
        state.characterStatus = passingData
    },
    [REQUEST_MY_INVENTORY] (state, passingDate){
        state.inventoryList = passingDate
    },
    [DAMAGED_MONSTERS_LIST] (state, passingDate){
        state.damagedMonstersList = passingDate
    }
}