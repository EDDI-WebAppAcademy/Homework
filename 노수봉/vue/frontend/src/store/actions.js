import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_ADD_RANDOM_MONSTER,
    REQUEST_MY_INVENTORY,
    REQUEST_CHARACTER_STATUS,

} from './mutation-types'

import axios from 'axios'

export default {
    requestDataFromSpring ({ commit }) {
        console.log("I'm from action - requestDataFromSpring()")

        return axios.get('http://localhost:7777/30th/vue2spring/test')
            .then((res) => {
                commit(REQUEST_DATA_FROM_SPRING, res.data.randomNumber)
            })
    },
    requestRandomGameItem ({commit}) {
        console.log("requestGameItemData()")

        return axios.get('http://localhost:7777/31th/rpg-game/random-shop-item-lists')
            .then((res) => {
                commit(REQUEST_RANDOM_SHOP_ITEM, res.data)
    })
    },
    requestAddRandomMonster ({commit}){
        console.log("requestAddRandomMonster()")

        return axios.get('http://localhost:7777/31th/rpg-game/add-many-random-monster-lists')
            .then((res) => {
            commit(REQUEST_ADD_RANDOM_MONSTER, res.data)
        })
    },
    requestBuyItem ({commit} , payload){
        console.log("requestBuyItem()")

        return axios.post('http://localhost:7777/31th/rpg-game/buy-item',
            { totalPrice: payload.calculatedPrice, itemLists: payload.selectedItems})
            .then((res) => {
                alert(res.data)
                commit()
            })
    },
    requestMyInventory ({ commit }) {
        console.log("requestMyInventory()")

        return axios.post('http://localhost:7777/31th/rpg-game/my-inventory')
            .then((res) => {
                commit(REQUEST_MY_INVENTORY, res.data)
            })
    },
    requestCharacterStatus ({ commit }) {
        console.log("requestCharacterStatus()")

        return axios.get('http://localhost:7777/31th/rpg-game/character-status')
            .then((res) => {
                commit(REQUEST_CHARACTER_STATUS, res.data)
            })
    }
}