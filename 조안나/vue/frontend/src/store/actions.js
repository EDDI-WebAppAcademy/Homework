import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_RANDOM_MONSTERS_LIST,
    REQUEST_CHARACTER_STATUS_LIST,
    REQUEST_MY_INVENTORY,
    DAMAGED_MONSTERS_LIST,
} from './mutation-types'

// npm install axios --save-dev
import axios from 'axios'

export default {
    requestDataFromSpring({commit}) {
        console.log("I'm from action - requestDataFromSpring()")
        return axios.get('http://localhost:7777/30th/vue2spring/test')
            .then((res) => {
                commit(REQUEST_DATA_FROM_SPRING, res.data.randomNumber)
            })
    },
    requestRandomGameItem({commit}) {
        console.log("requestGameItemData()")

        return axios.get('http://localhost:8888/rpg/random-shop-item-lists')
            .then((res) => {
                commit(REQUEST_RANDOM_SHOP_ITEM, res.data)
            })
    },

    requestRandomMonsterAdd({commit}) {
        console.log("requestRandomMonsterAdd()")

        return axios.get('http://localhost:8888/rpg/random-add-monsters')
            .then((res) => {
                commit(REQUEST_RANDOM_MONSTERS_LIST, res.data)
            })
    },
    requestCharacterStatus({commit}){
        console.log("requestCharacterStatus()")

        return axios.get('http://localhost:8888/rpg/character-status')
            .then((res) => {
                commit(REQUEST_CHARACTER_STATUS_LIST, res.data)
            })
    },
    requestBuyItem({commit}, payload) {
        console.log("requestBuyItem()")

        return axios.post('http://localhost:8888/rpg/buy-item',
            {totalPrice: payload.calculatedPrice, itemLists: payload.selectedItems})
            .then((res) => {
                alert(res.data)
                commit()
            })
    },
    requestMyInventory({commit}){
        console.log("viewMyInventory()")

        return axios.get('http://localhost:8888/rpg/my-inventory')
            .then((res) => {
                commit(REQUEST_MY_INVENTORY, res.data)
            })
    },
    bulletTimeDamage({commit}){
        console.log("bulletTime()")

        return axios.get('http://localhost:8888/rpg/skill-atk')
            .then((res) => {
                commit(DAMAGED_MONSTERS_LIST, res.data)
            })
    },

}