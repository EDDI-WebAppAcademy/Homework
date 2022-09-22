import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_RANDOM_MONSTERS_LIST,
    REQUEST_CHARACTER_STATUS_LIST,
    REQUEST_MY_INVENTORY,
    REQUEST_DAMAGED_MONSTERS_LIST,
    REQUEST_CHARACTER_STATUS_FROM_SPRING,
    REQUEST_CHARACTER_STATUS_UPDATE_FROM_SPRING,
    REQUEST_BOARD_LIST_FROM_SPRING,
    REQUEST_BOARD_FROM_SPRING,
    REQUEST_PRODUCT_BOARD_LIST_FROM_SPRING,

} from './mutation-types'

export default {
    [REQUEST_DATA_FROM_SPRING](state, passingData) {
        state.springFromVueTestValue = passingData
    },
    [REQUEST_RANDOM_SHOP_ITEM](state, passingData) {
        state.randomShopItem = passingData
    },
    [REQUEST_RANDOM_MONSTERS_LIST](state, passingData) {
        state.randomMonstersList = passingData
    },
    [REQUEST_CHARACTER_STATUS_LIST](state, passingData) {
        state.characterStatus = passingData
    },
    [REQUEST_MY_INVENTORY](state, passingData) {
        state.inventoryList = passingData
    },
    [REQUEST_DAMAGED_MONSTERS_LIST](state, passingData) {
        state.damagedMonstersList = passingData
    },
    [REQUEST_CHARACTER_STATUS_FROM_SPRING](state, passingData) {
        state.characterStatus = passingData
    },
    [REQUEST_CHARACTER_STATUS_UPDATE_FROM_SPRING](state, passingData) {
        state.characterStatusUpdateFlag = passingData
    },
    [REQUEST_BOARD_LIST_FROM_SPRING](state, passingData) {
        state.boards = passingData
    },
    [REQUEST_BOARD_FROM_SPRING](state, passingData){
        state.board = passingData
    },
    [REQUEST_PRODUCT_BOARD_LIST_FROM_SPRING] (state, passingData){
        state.productBoards = passingData
    },

}