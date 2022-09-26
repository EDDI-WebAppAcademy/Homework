import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_CURRENT_MONSTER,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_CHARACTER_STATUS_DATA,
    REQUEST_CHARACTER_INVENTORY, REQUEST_RANDOM_MONSTER,
    REQUEST_BOARD_LIST_FROM_SPRING,
    REQUEST_GOODS_BOARD_LIST_FROM_SPRING, REQUEST_GOODS_BOARD_FROM_SPRING
} from './mutation-types'

export default {
    [REQUEST_DATA_FROM_SPRING] (state, passingData) {
        state.springFromVueTestValue = passingData
    },
    [REQUEST_CURRENT_MONSTER] (state, passingData) {
        state.currentMonster = passingData
    },
    [REQUEST_RANDOM_SHOP_ITEM] (state, passingData) {
        state.randomShopItem = passingData
    },
    [REQUEST_CHARACTER_STATUS_DATA] (state, passingData) {
        state.characterStatusData = passingData
    },
    [REQUEST_CHARACTER_INVENTORY] (state, passingData) {
        state.inventoryItems = passingData
    },
    [REQUEST_RANDOM_MONSTER] (state, passingData) {
        state.monsterListChangeFlag = passingData
    },
    [REQUEST_BOARD_LIST_FROM_SPRING] (state, passingData) {
        state.boards = passingData
    },
    [REQUEST_GOODS_BOARD_LIST_FROM_SPRING] (state, passingData) {
        state.goodsBoardList = passingData
    },
    [REQUEST_GOODS_BOARD_FROM_SPRING] (state, passingData) {
        state.goodsBoard = passingData
    }

}