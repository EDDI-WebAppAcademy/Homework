import {
    REQUEST_DATA_FROM_SPRING,
    SHOP_ITEM_LIST,
    MONSTER_LIST,
    CHARACTER_STATUS,
    INVENTORY_LIST,
    EXPERIENCE_KIND,
    REQUEST_BOARD_LIST_FROM_SPRING,
    REQUEST_BOARD_FROM_SPRING,
    REQUEST_ECOMMERCE_ITEM_FROM_SPRING,
    REQUEST_SELECTED_ITEM_FROM_SPRING
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
    [REQUEST_BOARD_LIST_FROM_SPRING] (state, passingData) {
        state.boards = passingData
    },
    [REQUEST_BOARD_FROM_SPRING] (state, passingData) {
        state.board = passingData
    },

    //상품 페이지
    [REQUEST_ECOMMERCE_ITEM_FROM_SPRING](state, passingData) {
        state.items = passingData
    },
    [REQUEST_SELECTED_ITEM_FROM_SPRING](state, passingData) {
        state.item = passingData
    },
}