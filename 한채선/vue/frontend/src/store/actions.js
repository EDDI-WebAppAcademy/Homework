import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_MONSTER,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_CHARACTER_STATUS
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

        return axios.get('http://localhost:7776/31th/rpg-game-controller/monster-list')
            .then((res) => {
                commit(REQUEST_RANDOM_MONSTER, res.data)
            })
    },

    requestShopItemData({ commit }) {
        console.log("requestShopItemData()")

        return axios.get('http://localhost:7776/31th/rpg-game-controller/random-shop-item-lists')
            .then((res) => {
                commit(REQUEST_RANDOM_SHOP_ITEM, res.data)
            })
    },
    requestCharacterStatus({ commit }) {
        console.log("requestShopItemData()")

        return axios.get('http://localhost:7776/31th/rpg-game-controller/character-info')
            .then((res) => {
                commit(REQUEST_CHARACTER_STATUS, res.data)
            })
    }

}