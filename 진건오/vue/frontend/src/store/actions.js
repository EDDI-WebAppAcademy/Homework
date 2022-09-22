import {
    REQUEST_DATA_FROM_SPRING,
    SHOP_ITEM_LIST,
    MONSTER_LIST,
    CHARACTER_STATUS,
    INVENTORY_LIST,
    EXPERIENCE_KIND,
    REQUEST_BOARD_LIST_FROM_SPRING,
    REQUEST_BOARD_FROM_SPRING,
    REQUEST_SELECTED_ITEM_FROM_SPRING,
    REQUEST_ECOMMERCE_ITEM_FROM_SPRING,
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
    },
    requestBoardListFromSpring ({ commit }) {
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
    requestCreateBoardContentsToSpring ({ }, payload) {
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

    //상품 페이지
    requestSellItemListFromSpring ({ commit }) {
        console.log('requestSellItemListFromSpring()')

        return axios.get('http://localhost:7777/ecommerce/item/list')
            .then((res) => {
                commit(REQUEST_ECOMMERCE_ITEM_FROM_SPRING, res.data)
            })
    },
    requestSelectedItemFromSpring({commit}, itemId) {
        console.log("requestSelectedItemFromSpring()")

        return axios.get(`http://localhost:7777/ecommerce/${itemId}`)
            .then((res) => {
                commit(REQUEST_SELECTED_ITEM_FROM_SPRING, res.data)
            });
    },
    // eslint-disable-next-line no-empty-pattern
    requestCreateSellItemToSpring({ }, payload) {
        console.log("requestCreateSellItemToSpring")

        const { itemName, seller, itemPrice, itemInformation } = payload
        return axios.post('http://localhost:7777/ecommerce/register/item',
            { itemName, seller, itemPrice, itemInformation })
            .then(() => {
                alert("상품 등록 완료")
            });
    },
    // eslint-disable-next-line no-empty-pattern
    requestCreateUserToSpring({ }, payload){
        console.log("requestCreateUserToSpring")

        const { userName, userId, userPassword } = payload
        return axios.post('http://localhost:7777/ecommerce/sign-up/user',
            {userName, userId, userPassword})
            .then(() => {
                alert("회원가입 완료")
            });
    }
}