import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_INVENTORY_ITEMS,
    REQUEST_DEFAULT_CHARACTER_STATUS,
    REQUEST_DEFAULT_MONSTER_LIST,
    REQUEST_HUNDRED_MONSTER_LIST,
} from './mutation-types'


export default {
    [REQUEST_DATA_FROM_SPRING](state, passingData){
        state.springFromVueTestValue = passingData
    },
    [REQUEST_RANDOM_SHOP_ITEM] (state, passingData) {
        state.randomShopItem = passingData
    },
    [REQUEST_INVENTORY_ITEMS] (state, passingData) {
        state.addBuyItemsToInventory = passingData
    },
    [REQUEST_DEFAULT_CHARACTER_STATUS] (state, passingData) {
        state.CharacterStatus = passingData
    },
    [REQUEST_DEFAULT_MONSTER_LIST] (state, passingData) {
        state.defaultMonsterList = passingData
    },
    [REQUEST_HUNDRED_MONSTER_LIST] (state, passingData) {
        state.hundredMonsterLIst = passingData
    },

}