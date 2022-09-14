import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_GAME_CHARACTER,
    REQUEST_RANDOM_MONSTER,
    REQUEST_MY_INVENTORY,
    // REQUEST_CHARACTER_LEVEL_UP
} from './mutation-types'

export default {
    [REQUEST_DATA_FROM_SPRING] (state, passingData) {
        state.springFromVueTestValue = passingData
    },
    [REQUEST_RANDOM_SHOP_ITEM] (state, passingData) {
        state.randomShopItem = passingData
    },
    [REQUEST_RANDOM_MONSTER] (state, passingData) {
        state.randomMonster = passingData
    },
    [REQUEST_GAME_CHARACTER] (state, passingData) {
        state.characterStatus = passingData
    },
    [REQUEST_MY_INVENTORY] (state, passingData) {
        state.myInventory = passingData
    }
}