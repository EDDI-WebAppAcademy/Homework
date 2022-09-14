import {
    REQUEST_CHARACTER_STATUS_DATA,
    REQUEST_EQUIPMENT_DATA,
    REQUEST_INVENTORY_DATA,
    REQUEST_MONSTER_DATA,
    REQUEST_STOCK_DATA,
} from './mutation-types'


// npm install axios --save-dev
// cmd 해당 폴더로 들어가서 위의 텍스트 치면 알아서 설치됨.
import axios from 'axios'

export default {
    //Critical Section 관련 정리가 필요함(월요일)
    //Critical Section때문에 mutation에 저장해야 하는 이유가 있음
    requestCharacterStatusData ({ commit }) {
        return axios.get('http://localhost:7777/make-game-alone/start/status')
            .then((res) => {
                commit(REQUEST_CHARACTER_STATUS_DATA, res.data)
            })
    },

    requestMonsterData ({ commit }) {
        return axios.get('http://localhost:7777/make-game-alone/start/playing')
            .then((res) => {
                commit(REQUEST_MONSTER_DATA, res.data)
            })
    },

    requestStockData ({ commit }) {
        return axios.get('http://localhost:7777/make-game-alone/start/stock-up')
            .then((res) => {
                commit(REQUEST_STOCK_DATA, res.data)
            })
    },

    requestInventoryData ({ commit }) {
        return axios.get('http://localhost:7777/make-game-alone/start/show-my-inven')
            .then((res) => {
                commit(REQUEST_INVENTORY_DATA, res.data)
            })
    },

    requestEquipmentData ({ commit }) {
        return axios.get('http://localhost:7777/make-game-alone/start/current-equip')
            .then((res) => {
                commit(REQUEST_EQUIPMENT_DATA, res.data)
            })
    },

    //데이터 보내기
    requestBuyItem ({ commit }, payload) {
        return axios.post('http://localhost:7777/make-game-alone/start/buy-items',
            { shoppingCart: payload })
            .then((res) => {
                alert(res.data)
                commit()
            })
    },

    requestEquipItem({ commit }, payload) {
        return axios.post('http://localhost:7777/make-game-alone/start/equipment',
            { receiveEquipItem : payload })
            .then((res) => {
                alert(res.data + "전송 완료")
                commit()
            })
    },

    requestRemoveEquipItem({ commit }, payload) {
        return axios.post('http://localhost:7777/make-game-alone/start/remove-equipment',
            { receiveRemoveEquipItem : payload })
            .then((res) => {
                alert(res.data + "전송 완료")
                commit()
            })
    },
}