import {
    REQUEST_CHARACTER_DATA_FROM_SPRING,
    REQUEST_SHOP_ITEMS_DATA_FROM_SPRING,
    REQUEST_AVAILABILITY_OF_PURCHASE_FROM_SPRING,
    POST_ITEMS_BEFORE_PAYMENT,
} from './mutation-types'


// npm install axios --save-dev
// cmd 해당 폴더로 들어가서 위의 텍스트 치면 알아서 설치됨.
import axios from 'axios'

export default {

    requestCharacterDataFromSpring ({ commit }) {
        return axios.get('http://localhost:7777/2nd/response-character-status')
            .then((res) => {
                commit(REQUEST_CHARACTER_DATA_FROM_SPRING, res.data)
            })
    },

    requestShopItemsDataFromSpring ({ commit }) {
        return axios.get('http://localhost:7777/2nd/response-shop-items')
            .then((res) => {
                commit(REQUEST_SHOP_ITEMS_DATA_FROM_SPRING, res.data)
            })
    },

    requestAvailabilityOfPurchaseFromSpring ({ commit }) {
        return axios.get('http://localhost:7777/2nd/response-availability-of-purchase')
            .then((res) => {
                commit(REQUEST_AVAILABILITY_OF_PURCHASE_FROM_SPRING, res.data)
            })
    },

    purchaseRequest ({ commit }, payload) {
        return axios.post('http://localhost:7777/2nd/receive-invoice',
            { shoppingCart: payload })
            .then((res) => {
                console.log(res.data.name + "를 구매 요청합니다.")
                commit(POST_ITEMS_BEFORE_PAYMENT, res.data.name)
            })
    },


}