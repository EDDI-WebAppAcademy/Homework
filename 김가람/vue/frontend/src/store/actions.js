import {
    REQUEST_CHARACTER_STATUS,
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
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
    requestCharacterStatus ({ commit }) {
        console.log("requestCharacterStatus")

        return axios.get('http://localhost:7777/31st/rpg-game/character-status')
            .then((res) => {
                commit(REQUEST_CHARACTER_STATUS, res.data)
            })
    }
}