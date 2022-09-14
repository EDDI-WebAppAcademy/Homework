import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_ADD_RANDOM_MONSTER,
    REQUEST_MY_INVENTORY,
    REQUEST_CHARACTER_STATUS,
} from './mutation-types'


export default {
    [REQUEST_DATA_FROM_SPRING] (state, passingData) {
        state.springFromVueTestValue = passingData
    },
    [REQUEST_RANDOM_SHOP_ITEM] (state, passingData) {
        state.randomShopItem = passingData
    },
    [REQUEST_ADD_RANDOM_MONSTER] (state, passingData) {
        state.addRandomMonster = passingData
    },
    [REQUEST_MY_INVENTORY] (state, passingData) {
        state.myInventory = passingData
    },
    [REQUEST_CHARACTER_STATUS] (state, passingData) {
        state.characterStatus = passingData
    }

}