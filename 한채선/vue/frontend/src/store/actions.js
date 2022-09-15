import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_MONSTER,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_CHARACTER_STATUS,
    REQUEST_CHARACTER_INVENTORY,
  /*  REQUEST_UPDATED_CHARACTER_INVENTORY,*/
} from './mutation-types'

// npm install axios --save-dev
import axios from 'axios'

export default {
    requestDataFromSpring ({ commit }) {
        console.log("I'm from action - requestDataFromSpring()")

        return axios.get('http://localhost:7776/30th/vue2spring/test')
            .then((res) => {
                commit(REQUEST_DATA_FROM_SPRING, res.data.randomNum)
            })
    },

    requestRandomMonsterData ({ commit }) {
        console.log("requestRandomMonsterData")

        return axios.get('http://localhost:7776/31th/monster-controller/monster-list')
            .then((res) => {
                commit(REQUEST_RANDOM_MONSTER, res.data)
            })
    },

    requestShopItemData({ commit }) {
        console.log("requestShopItemData()")

        return axios.get('http://localhost:7776/31th/market-controller/random-shop-item-lists')
            .then((res) => {
                commit(REQUEST_RANDOM_SHOP_ITEM, res.data)
            })
    },

    requestCharacterStatus({ commit }) {
        console.log("requestCharacterStatus()")

        return axios.get('http://localhost:7776/31th/character-controller/character-status')
            .then((res) => {
                commit(REQUEST_CHARACTER_STATUS, res.data)
            })
    },



    requestBuyItem({ commit }, payload) {
        console.log("requestBuyItem()")

        return axios.post('http://localhost:7776/31th/character-controller/buy_item',
            { itemList: payload })
            .then(() => {
                axios.get('http://localhost:7776/31th/character-controller/character-inventory')
                    .then((res) => {
                        commit(REQUEST_CHARACTER_INVENTORY, res.data)
                    })
            })
    },


    requestCharacterInventory({ commit }) {
        console.log("requestCharacterInventory()")

        return axios.get('http://localhost:7776/31th/character-controller/character-inventory')
            .then((res) => {
                commit(REQUEST_CHARACTER_INVENTORY, res.data)
            })
    },


    requestExchangingExpToStatus({ commit }, payload ) {
        console.log("requestExpExchangeStatusList()")

        return axios.post('http://localhost:7776/31th/character-controller/character-exp-to-status',
            payload)
            .then((res) => {
                alert(res.data)
            commit()
        })
    },

}