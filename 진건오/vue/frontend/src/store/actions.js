import {
    REQUEST_DATA_FROM_SPRING,
    SHOP_ITEM_LIST,
    MONSTER_LIST,
    CHARACTER_STATUS,
    INVENTORY_LIST,
    BUY_ITEM_ADD_INVENTORY,
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
    requestShopItemLists({ commit }){
        return axios.get('http://localhost:7777/rpg/game/shop-item')
            .then((res) => {
                commit(SHOP_ITEM_LIST, res.data)
            });
    },
    requestAddMonsterLists({commit}) {
        return axios.get('http://localhost:7777/rpg/game/create-monster')
            .then((res) => {
                commit(MONSTER_LIST, res.data)
            });
    },
    requestCharacterStatus({commit}) {
        return axios.get('http://localhost:7777/32th/vue2spring/setting-character-status')
            .then((res) =>{
                commit(CHARACTER_STATUS, res.data)
            });
    },
    requestInventoryList({commit}) {
        return axios.get('http://localhost:7777/32th/vue2spring/setting-inventory')
            .then((res) => {
                commit(INVENTORY_LIST, res.data)
            });
    },
    requestBuyItem ({ commit }, payload) {
        console.log("requestBuyItem()")

        return axios.post('http://localhost:7777/32th/vue2spring/buy-item',
            { totalPrice: payload.calculatedPrice, itemLists: payload.selectedItems })
            .then((res) => {
                alert("구매완료")
                commit(BUY_ITEM_ADD_INVENTORY,res.data)
            })
    },
    requestExperienceKind({commit}) {
        return axios.get('http://localhost:7777/32th/vue2spring/experience-change')
            .then((res) => {
                commit(EXPERIENCE_KIND, res.data)
            });

    },
    requestSelectedExpType({commit}, payload) {
        console.log('requestSelectedExpType')

        return axios.post('http://localhost:7777/32th/vue2spring/receive-change-Exp-Types',
            {experienceType: payload.selectedExpTypes})
            .then((res) => {
                alert("선택완료")
                commit(EXPERIENCE_KIND, res.data)
            });
    },

}