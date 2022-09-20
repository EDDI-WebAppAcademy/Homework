import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_RANDOM_MONSTER,
    REQUEST_CHARACTER_STATUS_FROM_SPRING,
    REQUEST_INVENTORY_ITEM,
    REQUEST_MONSTER_LIST,
    REQUEST_BOARD_LIST_FROM_SPRING, REQUEST_BOARD_FROM_SPRING

} from './mutation-types'

// npm install axios --save-dev
import axios from 'axios'

export default {
    // actions을 호출하게되면 commit이 알아서 붙음
    requestDataFromSpring({ commit }) {
        console.log("I'm from action - requestDataFromSpring()")

        // 해당 URL을 요청 -> 우리가 웹브라우저에 주소를 입력하고 치는 것
        // axios의 핵심업무 : !요청! -> 통신을 할 수 있게됨, 데이터를 주고 받을 수 있음
        return axios.get('http://localhost:7777/30th/vue2Spring/test')
            // Spring에서 동작 후 then이 동작, 리턴된 값이 res에 들어감.
            .then((res) => {
                // 이 commit은 mutation으로 연결됨.
                // mutation은 Critical Section과 관련된 사항때문에 필요함
                // 쓰레드 동시다발적으로 동작 -> A가 할때는 A가 끝날때까지 대기, B가 할때는 B 끝날때까지 대기
                // 꼬이는 것을 방지하기위해 mutation이 필요
                // res.data를 변경할 수 있는 애들이 여럿 존재
                // 맨 마지막에 수정하고 나간 것이 남을 것인데
                // 순서가 뒤죽박죽하여 변형이 발생. 확실하게 해당 데이터 자체를 보장해라!
                // commit을 통해 mutation에 들어간 후 state에 값이 들어감.
                commit(REQUEST_DATA_FROM_SPRING, res.data.randomNumber)
                //res.data -> { "randomNumber": 1 } json 형태의 출력 / res.data.randomNumber -> 숫자 출력
            })
    },
    requestRandomShopItem ({ commit }) {
        console.log("requestShopItemData()")

        return axios.get('http://localhost:7777/31st/rpg-game/random-shop-item-lists')
            .then((res) => {
                commit(REQUEST_RANDOM_SHOP_ITEM, res.data)
            })
    },
    requestMonsterList ({commit}) {
      console.log("requestMonsterList")

      return axios.get('http://localhost:7777/31st/rpg-game/view-monster-list')
          .then((res) => {
              commit(REQUEST_MONSTER_LIST, res.data)
          })
    },
    requestRandomMonster ({commit}) {
        console.log("requestRandomMonster")

        return axios.get('http://localhost:7777/31st/rpg-game/add-random-monster')
            .then((res) => {
                commit(REQUEST_RANDOM_MONSTER, res.data)
            })
    },
    requestCharacterStatusFromSpring ({commit}) {
        console.log("requestCharacterStatusFromSpring")

        return axios.post('http://localhost:7777/31st/rpg-game/character-status')
            .then((res) => {
                commit(REQUEST_CHARACTER_STATUS_FROM_SPRING, res.data)
            })
    },
    requestBuyItem ({ commit }, payload) {
        console.log("requestBuyItem()")

        return axios.post('http://localhost:7777/31st/rpg-game/buy-item',
            { totalPrice: payload.calculatedPrice, itemLists: payload.selectedItems})
            .then((res) => {
                alert(res.data)
                commit()
            })
    },
    requestInventoryItems ({ commit }) {
        console.log("requestInventoryItems")

        return axios.get('http://localhost:7777/31st/rpg-game/my-inventory')
            .then((res) => {
                commit(REQUEST_INVENTORY_ITEM, res.data)
            })
    },
    requestExpExchangeFromSpring ({ dispatch }, payload) {
        console.log("requestExpExchangeFromSpring")

        return axios.post('http://localhost:7777/31st/rpg-game/exchange', payload)
            .then((res) => {
                if (res.data == true) {
                    dispatch('requestCharacterStatusFromSpring')
                }
            })
    },
    requestEquipItemFromSpring(payload) {
        console.log("requestEquipItemFromSpring")

        return axios.post('http://localhost:7777/31st/rpg-game/equip-item',
            { equippedItems: payload })
            .then(() => {
                alert('전송 완료')
            })
    },
    requestBoardListFromSpring({ commit }) {
        console.log("requestBoardListFromSpring()")

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

        const { title, writer, content } = payload
        return axios.post('http://localhost:7777/39th/jpa/board/register',
            { title, writer, content })
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
}