import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_MY_INVENTORY,
    REQUEST_ADD_MONSTER
} from './mutation-types'

// npm install axios --save-dev
import axios from 'axios'

export default {
    // Critical Section 관련 정리가 필요함
    requestDataFromSpring ({ commit }) {
        console.log("I'm from action - requestDataFromSpring()")
        return axios.get('http://localhost:8888/30th/vue2spring/test')
            .then((res) => {
                commit(REQUEST_DATA_FROM_SPRING, res.data.randomNumber)
            })
    },
    requestRandomGameItem ({ commit }) {
        console.log("requestGameItemData()")

        return axios.get('http://localhost:8888/31th/rpg-game/random-shop-item-lists')
            .then((res) => {
                commit(REQUEST_RANDOM_SHOP_ITEM, res.data)
            })
    },
    requestBuyItem ({ commit }, payload) {
        console.log("requestBuyItem()")

        return axios.post('http://localhost:8888/31th/rpg-game/buy-item',
            { totalPrice: payload.calculatedPrice, itemLists: payload.selectedItems })
            .then((res) => {
                alert(res.data)
                commit()
            })
    },

    requestMyInventory ({ commit }) {
        console.log("requestMyInventory()")

        return axios.post('http://localhost:8888/31th/rpg-game/my-inventory')
            .then((res) => {
                commit(REQUEST_MY_INVENTORY, res.data)
            })
    },
    requestAddMonster ({ commit }) {
        console.log("requestAddMonster()")

        return axios.post('http://localhost:8888/31th/rpg-game/add-hundred-monster')
            .then((res) => {
                commit(REQUEST_ADD_MONSTER, res.data)
            })
    },
}