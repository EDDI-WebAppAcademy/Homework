import {
    REQUEST_CHARACTER_STATUS,
    REQUEST_DATA_FROM_SPRING, REQUEST_DEFAULT_MONSTERS, REQUEST_MANY_MONSTERS, REQUEST_MY_INVENTORY,
    REQUEST_RANDOM_SHOP_ITEM,
} from './mutation-types'

// npm install axios --save-dev
import axios from 'axios'

export default {
    requestDataFromSpring ({ commit }) {
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
    requestRandomGameItem ({ commit }) {
        console.log("requestGameItemData()")

        return axios.get('http://localhost:7777/31th/rpg-game/random-shop-item-lists')
            .then((res) => {
                commit(REQUEST_RANDOM_SHOP_ITEM, res.data)
            })
    },
    requestBuyItem ({ commit }, payload) {
        console.log("requestBuyItem()")

        return axios.post('http://localhost:7777/31th/rpg-game/buy-item',
            { totalPrice: payload.calculatedPrice, itemLists: payload.selectedItems })
            .then((res) => {
                alert(res.data)
                commit(res.data)
            })
    },
    requestMyInventory ({ commit }) {
        console.log("requestMyInventory()")

        return axios.post('http://localhost:7777/31th/rpg-game/my-inventory')
            .then((res) => {
                commit(REQUEST_MY_INVENTORY, res.data)
            })
    },
    requestManyMonsters ({ commit }) {
        console.log("requestManyMonsters()")

        return axios.post('http://localhost:7777/31th/rpg-game2/many-monsters')
            .then((res) => {
                commit(REQUEST_MANY_MONSTERS, res.data)
            })
    },
    requestDefaultMonsters ({ commit }) {
        console.log("requestDefaultMonsters()")

        return axios.post('http://localhost:7777/31th/rpg-game2/default-monsters')
            .then((res) => {
                commit(REQUEST_DEFAULT_MONSTERS, res.data)
            })
    },
    requestCharacterStatus ({commit}) {
        console.log("requestCharacterStatus")

        return axios.post('http://localhost:7777/31th/rpg-game3/character-status')
            .then((res) => {
                commit(REQUEST_CHARACTER_STATUS, res.data)
            })
    },
}