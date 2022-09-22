import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_MONSTER,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_CHARACTER_STATUS,
    REQUEST_CHARACTER_INVENTORY,
    REQUEST_BOARD_LIST_FROM_SPRING, REQUEST_BOARD_FROM_SPRING, REQUEST_PRODUCT_BOARD_LIST,

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



    requestBuyItem({ dispatch }, payload) {
        console.log("requestBuyItem()")

        return axios.post('http://localhost:7776/31th/character-controller/buy_item',
            { itemList: payload })
            .then((res)=> {
                if(res.data == true) {
                    dispatch('requestCharacterInventory')
                    dispatch('requestCharacterStatus')
                    console.log('requestBuyItem() : requestCharacterInventory() & requestCharacterStatus()')
                    alert('구매 완료!')
                }
                else {
                    alert('소지금이 부족합니다')
                }
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

    requestBoardListFromSpring({commit}) {
        console.log("requestBoardListFromSpring()")
        return axios.get('http://localhost:7776/39th/jpa/board/list')
            .then((res) => {
                commit(REQUEST_BOARD_LIST_FROM_SPRING, res.data)
        })
    },

    requestBoardFromSpring({ commit }, boardNo) {

        console.log("requestBoardFromSpring()")

        return axios.get(`http://localhost:7776/39th/jpa/board/${boardNo}`)
            .then((res) => {
                commit(REQUEST_BOARD_FROM_SPRING, res.data)
            })
    },


    // eslint-disable-next-line no-empty-pattern
    requestCreatBoardContentsToSpring({ }, payload) {
        console.log("requestCreatBoardContentsToSpring()")

        const { title, content, writer } = payload
        return axios.post('http://localhost:7776/39th/jpa/board/register',
            {title, content, writer})
            .then(() => {
                alert('게시물 등록 성공')
            })
    },

    // eslint-disable-next-line no-empty-pattern
    requestDeleteBoardToSpring({ }, boardNo) {
        console.log("requestDeleteBoardToSpring()")

        return axios.delete(`http://localhost:7776/39th/jpa/board/${boardNo}`)
            .then(() => {
                alert('삭제 성공')
            })
    },

    // eslint-disable-next-line no-empty-pattern
    requestBoardModifyToSpring({ }, payload) {
        console.log("requestBoardModifyToSpring()")

        const {  boardNo, title, writer, content, regDate } = payload

        return axios.put(`http://localhost:7776/39th/jpa/board/${boardNo}`, { title, content, writer, regDate })
            .then(()=> {
                alert('수정 성공')
            })
    },

    /* ---productBoard--- */
    requestProductBoardList({ commit }){
        console.log("requestProductBoardList()")

        return axios.get('http://localhost:7776/41th/jpa/prudoct-board/board-list')
            .then((res) => {
            commit(REQUEST_PRODUCT_BOARD_LIST, res.data)
            })
    },

}