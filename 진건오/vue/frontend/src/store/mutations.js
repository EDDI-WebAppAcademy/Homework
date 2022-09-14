import {
    REQUEST_DATA_FROM_SPRING,
    SHOP_ITEM_LIST,
    MONSTER_LIST,
    CHARACTER_STATUS,
    INVENTORY_LIST,
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
        state.characterStatusValues = passingData
    },
    [INVENTORY_LIST](state, passingData) {
        state.inventoryItemList = passingData
    },
    [EXPERIENCE_KIND](state, passingData) {
        state.expKindList = passingData
    },
}