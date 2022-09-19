import {
    REQUEST_CHARACTER_DATA_FROM_SPRING,
    REQUEST_SHOP_ITEMS_DATA_FROM_SPRING,
    REQUEST_AVAILABILITY_OF_PURCHASE_FROM_SPRING,
    POST_ITEMS_BEFORE_PAYMENT,
} from './mutation-types'

export default {
    [REQUEST_CHARACTER_DATA_FROM_SPRING] (state, passingData) {
        state.characterStatus = passingData
    },
    [REQUEST_SHOP_ITEMS_DATA_FROM_SPRING] (state, passingData) {
        state.shopItemList = passingData
    },
    [REQUEST_AVAILABILITY_OF_PURCHASE_FROM_SPRING] (state, passingData) {
        state.availabilityOfPurchase = passingData
    },




    [POST_ITEMS_BEFORE_PAYMENT] (state, passingData) {
        state.ItemsbeforePayment = passingData
    },
}
