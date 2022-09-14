import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_MONSTER,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_CHARACTER_STATUS_DATA,
    REQUEST_CHARACTER_INVENTORY
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
    [REQUEST_CHARACTER_STATUS_DATA] (state, passingData) {
        state.characterStatusData = passingData
    },
    [REQUEST_CHARACTER_INVENTORY] (state, passingData) {
        state.inventoryItems = passingData
    },
}