import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_MONSTER,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_CHARACTER_STATUS,
    REQUEST_CHARACTER_INVENTORY,
    REQUEST_UPDATED_CHARACTER_INVENTORY, REQUEST_BOARD_LIST_FROM_SPRING,
} from './mutation-types'

export default {
    [REQUEST_DATA_FROM_SPRING] (state, passingData) {
        state.springFromVueTestValue = passingData
    },
    [REQUEST_RANDOM_MONSTER] (state, passingData) {
        state.randomMonster = passingData
    },
    [REQUEST_RANDOM_SHOP_ITEM] (state, passingData) {
        state.randomShopItem = passingData
    },
    [REQUEST_CHARACTER_STATUS] (state, passingData) {
        state.characterStatus = passingData
    },
    [REQUEST_CHARACTER_INVENTORY] (state, passingData) {
        state.characterInventory = passingData
    },
    [REQUEST_UPDATED_CHARACTER_INVENTORY] (state, passingData) {
        state.updateCharacterInventoryFlag = passingData
    },
    [REQUEST_BOARD_LIST_FROM_SPRING] (state, passingData) {
        state.boards = passingData
    }
}