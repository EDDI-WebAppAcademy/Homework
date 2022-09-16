import {
    REQUEST_DATA_FROM_SPRING,
    SHOP_ITEM_LIST,
    MONSTER_LIST,
    CHARACTER_STATUS,
    INVENTORY_LIST,
    EXPERIENCE_KIND
} from './mutation-types'

// npm install axios --save-dev
import axios from 'axios'

export default {
    requestDataFromSpring ({ commit }) {
        return axios.get('http://localhost:7777/30th/vue2spring/test')
            .then((res) => {
                commit(REQUEST_DATA_FROM_SPRING, res.data.randomNumber)
            })
    },
    requestShopItemListsFromSpring({ commit }){
        return axios.get('http://localhost:7777/shop/shop-item')
            .then((res) => {
                commit(SHOP_ITEM_LIST, res.data)
            });
    },
    requestAddMonsterListsFromSpring({commit}) {
        return axios.get('http://localhost:7777/monster/create-monster')
            .then((res) => {
                commit(MONSTER_LIST, res.data)
            });
    },
    requestCharacterStatusFromSpring({commit}) {
        return axios.post('http://localhost:7777/character/setting-character-status')
            .then((res) =>{
                commit(CHARACTER_STATUS, res.data)
            });
    },
    requestInventoryListFromSpring({commit}) {
        return axios.get('http://localhost:7777/shop/setting-inventory')
            .then((res) => {
                commit(INVENTORY_LIST, res.data)
            });
    },
    requestBuyItemToSpring ({ commit }, payload) {
        console.log("requestBuyItem()")

        return axios.post('http://localhost:7777/shop/buy-item',
            { totalPrice: payload.calculatedPrice, itemLists: payload.selectedItems })
            .then((res) => {
                alert(res.data)
                commit(SHOP_ITEM_LIST)
            })
    },
    requestExperienceKindFromSpring({commit}) {
        return axios.get('http://localhost:7777/experience/setting-value')
            .then((res) => {
                commit(EXPERIENCE_KIND, res.data)
            });

    },
    requestCharacterStatusChangeFromSpring({dispatch}, payload){
        return axios.post('http://localhost:7777/experience/change',payload)
            .then((res) => {
                if (res.data == true) {
                    dispatch('requestCharacterStatusFromSpring')
                }
            });
    }


}