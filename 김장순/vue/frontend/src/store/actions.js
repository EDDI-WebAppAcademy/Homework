import {
    REQUEST_CHARACTER_STATUS,
    REQUEST_DATA_FROM_SPRING,
    REQUEST_DEFAULT_MONSTERS,
    REQUEST_EXP_TRADE_SYSTEM,
    REQUEST_MANY_MONSTERS,
    REQUEST_MY_INVENTORY,
    REQUEST_RANDOM_SHOP_ITEM,

    REQUEST_BOARD_LIST_FROM_SPRING,
    REQUEST_BOARD_FROM_SPRING,

    REQUEST_GOODS_SALE_BOARD_LIST_FROM_SPRING,
} from './mutation-types'

// npm install axios --save-dev
import axios from 'axios'

export default {
    requestDataFromSpring({commit}) {
        console.log("I'm from action - requestDataFromSpring()")

        return axios.get('http://localhost:7777/30th/vue2spring/test') //해당 url을 요청(핵심업무), 웹브라우저에 url을 입력한것과 같은 역할을 함
            .then((res) => {
                commit(REQUEST_DATA_FROM_SPRING, res.data.randomNumber) //커밋으로 뮤테이션에 있는 REQUEST_DATA_FROM_SPRING 호출
                // 여러 쓰레드는 동시다발적으로 state에 접근가능
                // 그렇기에 하나의 쓰레드가 동작중에는 나머지 쓰레드가 대기해야함
                //실제로 a,c,b 순으로 데이터 작업이 이뤄줘야 할 때 그것을 보장해주기 위해 commit이 필요
                //그 값을 state로 전달
                //randomNumber를 기재하지 않을 시 제이슨 형태로 전달
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
                commit(res.data)
            })
    },
    requestMyInventory({commit}) {
        console.log("requestMyInventory()")

        return axios.post('http://localhost:7777/31th/rpg-game/my-inventory')
            .then((res) => {
                commit(REQUEST_MY_INVENTORY, res.data)
            })
    },
    requestManyMonsters({commit}) {
        console.log("requestManyMonsters()")

        return axios.post('http://localhost:7777/31th/rpg-game2/many-monsters')
            .then((res) => {
                commit(REQUEST_MANY_MONSTERS, res.data)
            })
    },
    requestDefaultMonsters({commit}) {
        console.log("requestDefaultMonsters()")

        return axios.post('http://localhost:7777/31th/rpg-game2/default-monsters')
            .then((res) => {
                commit(REQUEST_DEFAULT_MONSTERS, res.data)
            })
    },
    requestCharacterStatus({commit}) {
        console.log("requestCharacterStatus")

        return axios.post('http://localhost:7777/31th/rpg-game3/character-status')
            .then((res) => {
                commit(REQUEST_CHARACTER_STATUS, res.data)
            })
    },
    requestExpTradeSystem({commit}) {
        console.log("requestExpTradeSystem")

        return axios.get('http://localhost:7777/31th/rpg-game3/exp-trade-system')
            .then((res) => {
                commit(REQUEST_EXP_TRADE_SYSTEM, res.data)
            })
    },
    requestBoardListFromSpring({commit}) {
        console.log('requestBoardListFromSpring()')

        return axios.get('http://localhost:7777/39th/jpa/board/list')
            .then((res) => {
                commit(REQUEST_BOARD_LIST_FROM_SPRING, res.data)
            })
    },
    requestBoardFromSpring({commit}, boardNo) {
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
    requestDeleteBoardToSpring({}, boardNo) {
        console.log('requestDeleteBoardToSpring()')

        return axios.delete(`http://localhost:7777/39th/jpa/board/${boardNo}`)
            .then(() => {
                alert('삭제 성공')
            })
    },
    // eslint-disable-next-line no-empty-pattern
    requestBoardModifyToSpring({}, payload) {
        console.log('requestBoardModifyToSpring()')

        const {title, content, boardNo, writer, regDate} = payload

        return axios.put(`http://localhost:7777/39th/jpa/board/${boardNo}`, //` 가변인자 처리
            {title, content, writer, regDate})
            .then(() => {
                alert('수정 성공')
            })
    },
    requestGoodsSaleBoardListFromSpring({commit}) {
        console.log('requestGoodsSaleBoardListFromSpring()')

        return axios.get('http://localhost:7777/goods/sale/list')
            .then((res) => {
                commit(REQUEST_GOODS_SALE_BOARD_LIST_FROM_SPRING, res.data)
            })
    },
    // eslint-disable-next-line no-empty-pattern
    requestCreateGoodsBoardContentsToSpring({}, payload) {
        console.log('requestCreateGoodsBoardContentsToSpring()')

        const {title, content, seller, price} = payload
        return axios.post('http://localhost:7777/goods/sale/register',
            {title, content, seller, price})
            .then(() => {
                alert('상품 등록 성공')
            })
    },


}