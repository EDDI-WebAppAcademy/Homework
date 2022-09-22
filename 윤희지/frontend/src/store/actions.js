import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_MONSTER,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_CHARACTER_STATUS_DATA,
    REQUEST_CHARACTER_INVENTORY,
    REQUEST_CURRENT_MONSTER,
    REQUEST_BOARD_LIST_FROM_SPRING, REQUEST_GOODS_BOARD_LIST_FROM_SPRING
} from './mutation-types'

import axios from 'axios'

export default {
    requestRandomGameItem({ commit }) {
        console.log("requestGameItemData()")

        return axios.get('http://localhost:5959/31th/rpg-game/random-shop-item-lists')
            .then((res) => {
                commit(REQUEST_RANDOM_SHOP_ITEM, res.data)
            })
    },
    requestBuyItem({ commit }, payload) {
        console.log("requestBuyItem()")
        return axios.post('http://localhost:5959/31th/rpg-game/buy-items',
            { itemLists: payload.selectedItems })
            .then((res)=> {
                alert(res.data)
                commit()
            })
    },
    requestInventoryItems({ commit }) {
      console.log("requestInventoryItems()")

      return axios.get('http://localhost:5959/31th/rpg-game/inventory-lists')
          .then((res)=> {
              commit(REQUEST_CHARACTER_INVENTORY, res.data)
          })
    },
    requestEquippedItemLists({ commit }, payload) {
        console.log("requestEquippedItemLists()")

        return axios.post('http://localhost:5959/31th/rpg-game/equip-items',
            { equippedItemLists: payload.selectedItems })
            .then((res)=> {
                alert(res.data)
                commit()
                })
    },
    requestCurrentMonsterList({ commit }) {
        console.log("requestCurrentMonsterList()")

        return axios.get('http://localhost:5959/31th/rpg-game/send-current-monsterList-data')
            .then((res) => {
                commit(REQUEST_CURRENT_MONSTER, res.data)
            })
    },
    requestRandomMonsters({ commit }) {
        console.log("requestRandomMonster()")

        return axios.get('http://localhost:5959/31th/rpg-game/add-random-monsters')
            .then((res) => {
                commit(REQUEST_RANDOM_MONSTER, res.data)
            })
    },
    requestRemoveMonsterIdx({ commit }, payload) {
        console.log("requestRemoveMonsterIdx()")

        return axios.post('http://localhost:5959/31th/rpg-game/remove-monster',
            { removeMonsterIdx: payload.removeMonsterIdx })
            .then((res) => {
                commit(REQUEST_RANDOM_MONSTER, res.data)
            })
    },
    requestCharacterStatusData({ commit }) {
        console.log("requestCharacterStatusData()")

        return axios.get('http://localhost:5959/31th/rpg-game/character-status')
            .then((res)=> {
                commit(REQUEST_CHARACTER_STATUS_DATA, res.data)
            })
    },
    // Critical Section 관련 정리가 필요함(월요일)
    requestDataFromSpring({ commit }) { // 이 commit은 자동으로 붙음(뭐라 얘기 들었는데 까먹..)
        console.log("I'm from action - requestDataFromSpring()")
        // axios.get() 부분이 주소창에 ()안의 url을 입력한거랑 똑같이 작동함.(요청)
        return axios.get('http://localhost:7777/30th/vue2spring/test')
            // url에서 리턴값이 나오면 .then이 동작
            .then((res) => {
                // 받아온 데이터에서 필요한 값만 가져옴(??randomNumber 객체의 변수 randomNumber)
                commit(REQUEST_DATA_FROM_SPRING, res.data.randomNumber)
            })
    },
    requestBoardListFromSpring ({ commit }) {
        console.log('requestBoardListFromSpring()')

        return axios.get('http://localhost:7777/39th/jpa/board/list')
            .then((res) => {
                commit(REQUEST_BOARD_LIST_FROM_SPRING, res.data)
            })
    },
    // eslint-disable-next-line no-empty-pattern
    requestCreateBoardContentsToSpring ({ }, payload) {
        console.log('requestCreateBoardContentsToSpring()')

        const { title, content, writer } = payload
        return axios.post('http://localhost:7777/39th/jpa/board/register',
            { title, content, writer })
            .then(() => {
                alert('게시물 등록 성공')
            })
    },
    requestGoodsBoardListFromSpring({ commit }) {
        console.log('requestGoodsBoardListFromSpring()')

        return axios.get('http://localhost:7778/goods-board/list')
            .then((res)=> {
                commit(REQUEST_GOODS_BOARD_LIST_FROM_SPRING, res.data)
            })
    },
    // eslint-disable-next-line no-empty-pattern
    requestCreateGoodsBoardContentsToSpring({ }, payload) {
        console.log('requestCreateGoodsBoardContentsToSpring()')
        const { goodsName, price, seller, content } = payload
        return axios.post('http://localhost:7778/goods-board/register',
            { goodsName, price, seller, content })
            .then(() => {
                alert('상품 게시글 등록 완료')
            })

    },

}
