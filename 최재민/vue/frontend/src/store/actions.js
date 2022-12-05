import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_INVENTORY_ITEMS,
    REQUEST_DEFAULT_CHARACTER_STATUS,
    REQUEST_DEFAULT_MONSTER_LIST,
    REQUEST_HUNDRED_MONSTER_LIST,
    REQUEST_BOARD_LIST_FROM_SPRING,
    REQUEST_BOARD_FROM_SPRING,
    REQUEST_PRODUCT_BOARD_LIST_FROM_SPRING,
} from './mutation-types'

import axios from "axios";

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

        return axios.get('http://localhost:7777/31th/rpg-game/random-shop-item-lists')
            .then((res) => {
                commit(REQUEST_RANDOM_SHOP_ITEM, res.data)
            })
    },
    requestBuyItem({commit}, payload) {
        console.log("requestBuyItem()")

        return axios.post('http://localhost:7777/31th/rpg-game/buy-item',
            {totalPrice: payload.calculatedPrice, itemLists: payload.selectedItems})
            .then((res) => {
                alert(res.data)
                commit()
            })
    },
    requestEquipItem({commit}, payload) {
        console.log("requestEquipItem()")

        return axios.post('http://localhost:7777/31th/rpg-game/equip-item',
            {itemLists: payload})
            .then((res) => {
                alert(res.data)
                commit()
            })
    },
    requestInventoryItems({commit}) {
        console.log("requestInventoryItems()")

        return axios.post('http://localhost:7777/31th/rpg-game/inventory-items')
            .then((res) => {
                commit(REQUEST_INVENTORY_ITEMS, res.data)
            })
    },
    requestCharacterDefaultStatus({commit}) {
        console.log("requestCharacterDefaultStatus()")

        return axios.post('http://localhost:7777/31th/rpg-game/get-character-status')
            .then((res) => {
                commit(REQUEST_DEFAULT_CHARACTER_STATUS, res.data)
            })
    },
    requestDefaultMonsterList({commit}) {
        console.log("requestDefaultMonsterList()")

        return axios.post('http://localhost:7777/31th/rpg-game/defaultMnsters-List')
            .then((res) => {
                commit(REQUEST_DEFAULT_MONSTER_LIST, res.data)
            })
    },
    requestHundredMonsterLists({commit}) {
        console.log("requestHundredMonsterLists()")

        return axios.post('http://localhost:7777/31th/rpg-game/hundredMonsters-List')
            .then((res) => {
                commit(REQUEST_HUNDRED_MONSTER_LIST, res.data)
            })
    },
    requestBoardListFromSpring({commit}) {
        console.log('requestBoardListFromSpring()')

        return axios.get('http://localhost:7777/39th/jpa/board/list')
            .then((res) => {
                commit(REQUEST_BOARD_LIST_FROM_SPRING, res.data)
            })
    },
    requestBoardFromSpring ({ commit }, boardNo) {
        console.log('requestBoardFromSpring()')

        return axios.get(`http://localhost:7777/39th/jpa/board/${boardNo}`)
            .then((res) => {
                commit(REQUEST_BOARD_FROM_SPRING, res.data)
            })
    },
    // eslint-disable-next-line no-empty-pattern
    requestCreateBoardContentsToSpring({}, payload) {
        console.log('requestCreateBoardContentsToSpring()')

        const {title, content, writer} = payload
        return axios.post('http://localhost:7777/39th/jpa/board/register',
            {title, content, writer})
            .then(() => {
                alert('게시물 등록 성공')
            })
    },
    // eslint-disable-next-line no-empty-pattern
    requestDeleteBoardToSpring ({ }, boardNo) {
        console.log('requestDeleteBoardToSpring()')

        return axios.delete(`http://localhost:7777/39th/jpa/board/${boardNo}`)
            .then(() => {
                alert('삭제 성공')
            })
    },
    // eslint-disable-next-line no-empty-pattern
    requestBoardModifyToSpring ({ }, payload) {
        console.log('requestBoardModifyToSpring()')

        const {title, content, boardNo, writer, regDate} = payload

        return axios.put(`http://localhost:7777/39th/jpa/board/${boardNo}`,
            {title, content, writer, regDate})
            .then(() => {
                alert('수정 성공')
            })
    },
    requestProductListFromSpring({commit}) {
        console.log('requestProductListFromSpring()')

        return axios.get('http://localhost:7777/40th/product/board-list')
            .then((res) => {
                commit(REQUEST_PRODUCT_BOARD_LIST_FROM_SPRING,res.data)
            })
    },

}