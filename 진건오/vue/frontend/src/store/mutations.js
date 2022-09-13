import {
    REQUEST_DATA_FROM_SPRING,
    SHOP_ITEM_LIST,
    MONSTER_LIST,
    CHARACTER_STATUS,
    INVENTORY_LIST,
    BUY_ITEM_ADD_INVENTORY,
    EXPERIENCE_KIND,
} from './mutation-types'

export default {
    [REQUEST_DATA_FROM_SPRING] (state, passingData) {
        state.springFromVueTestValue = passingData
    },
    [SHOP_ITEM_LIST](state, passingData) {
        state.shopItemLists = passingData
    },
    [MONSTER_LIST](state, passingData) {
        state.monsterLists = passingData
    },
    [CHARACTER_STATUS](state, passingData) {
        state.characterStatus = passingData
    },
    [INVENTORY_LIST](state, passingData) {
        state.inventoryItemList = passingData
    },
    [BUY_ITEM_ADD_INVENTORY](state) {
        state.inventoryItemList
    },
    [EXPERIENCE_KIND](state, passingData) {
        state.expKindList = passingData
    },
}