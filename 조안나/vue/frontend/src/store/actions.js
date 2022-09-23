import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_RANDOM_MONSTERS_LIST,
    REQUEST_CHARACTER_STATUS_LIST,
    REQUEST_MY_INVENTORY,
    REQUEST_DAMAGED_MONSTERS_LIST,
    REQUEST_BOARD_LIST_FROM_SPRING,
    REQUEST_BOARD_FROM_SPRING,
    REQUEST_PRODUCT_BOARD_LIST_FROM_SPRING,

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
    requestCharacterStatusFromSpring({commit}) {
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
    requestMyInventory({commit}) {
        console.log("viewMyInventory()")

        return axios.get('http://localhost:8888/rpg/my-inventory')
            .then((res) => {
                commit(REQUEST_MY_INVENTORY, res.data)
            })
    },
    requestBulletTimeDamage({commit}) {
        console.log("bulletTime()")

        return axios.get('http://localhost:8888/rpg/skill-atk')
            .then((res) => {
                commit(REQUEST_DAMAGED_MONSTERS_LIST, res.data)
            })
    },
    requestExpExchangeFromSpring({dispatch}, payload) {
        console.log("requestExpExchangeFromSpring()")

        return axios.post('http://localhost:8888/rpg/exchange', payload)
            .then((res) => {
                if (res.data === true) {
                    dispatch('requestCharacterStatusFromSpring')
                }
            })
    },
    requestBoardListFromSpring({commit}) {
        console.log('requestBoardListFromSpring()')
        return axios.get('http://localhost:8888/board/list')
            .then((res) => {
                commit(REQUEST_BOARD_LIST_FROM_SPRING, res.data)
            })
    },
    // eslint-disable-next-line no-empty-pattern
    requestCreateBoardContentsToSpring({}, payload) {
        console.log('requestCreateBoardContentsToSpring()')

        const {title, content, writer} = payload
        return axios.post('http://localhost:8888/board/register',
            {title, content, writer})
            .then(() => {
                alert('게시물 등록 성공')
            })
    },
    requestBoardFromSpring ({ commit }, boardNo) {
        console.log('requestBoardFromSpring()')

        return axios.get(`http://localhost:8888/board/${boardNo}`)
            .then((res) => {
                commit(REQUEST_BOARD_FROM_SPRING, res.data)
            })
    },
    // eslint-disable-next-line no-empty-pattern
    requestDeleteBoardToSpring ({ }, boardNo) {
        console.log('requestDeleteBoardToSpring()')

        return axios.delete(`http://localhost:8888/board/${boardNo}`)
            .then(() => {
                alert('삭제 성공')
            })
    },
    // eslint-disable-next-line no-empty-pattern
    requestBoardModifyToSpring (payload) {
        console.log('requestBoardModifyToSpring()')

        const {title, content, boardNo, writer, regDate} = payload

        return axios.put(`http://localhost:8888/board/${boardNo}`,
            {title, content, writer, regDate})
            .then(() => {
                alert('수정 성공')
            })
    },

    // 상품 게시판 상품 리스트 요청
    requestProductBoardListFromSpring({commit}) {
        console.log('requestBoardListFromSpring()')
        return axios.get('http://localhost:8888/product-board/list')
            .then((res) => {
                commit(REQUEST_PRODUCT_BOARD_LIST_FROM_SPRING, res.data)
            })
    },
    // eslint-disable-next-line no-empty-pattern
    requestCreateProductBoardContentsToSpring({}, payload) {
    console.log('requestCreateProductBoardContentsToSpring()')

    const {title, image, category, price, writer, content} = payload
    return axios.post('http://localhost:8888/product-board/register',
        {title, image, category, price, writer, content})
        .then(() => {
            alert('상품 등록 성공!')
        })
    },

}