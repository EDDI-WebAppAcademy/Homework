import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_RANDOM_MONSTER,
    REQUEST_MY_INVENTORY,
    REQUEST_CHARACTER_STATUS
} from './mutation-types'

//npm install axios --save-dev
import axios from 'axios'

export default {
    requestDataFromSpring ({ commit }) { //커밋이라는게 날아오고 있어 자동으로 붙음 default mutation의 REQUEST_DATA_FROM_SPRING을 호출
        // 왜 굳이 커밋으로 보내? 액션에서 데이터 걍 넣으면 안됨?
        // 뮤테이션은 Critical section을 보호하는 업무.. 그게 뭔데
        // 월요일에 설명

        console.log("I'm from action - requestDataFromSpring()")
        //axios의 핵심 업무 : 요청 / 어디다 할건지는 (url이 정해)
        //이렇게 스프링과 통신 가능하게됨 데이터도 주고받을 수 있음
        return axios.get('http://localhost:7777/30th/vue2spring/test')//이게 해당 url 을 요청한거 (사용자가 url 입력한것과 동일한 동작을 수행함) 연결 시키는 자리가 어디냐 따라 바뀜 정해진건 아냐
            .then((res) => {
                commit(REQUEST_DATA_FROM_SPRING, res.data.randomNumber)
                //이 정보 변경할 수 있는 애들이 여러명일 수 있잖아 맨마지막에 수정하고 나간애가 적용되잖아
                //대기 매커니즘이 없으면. 실제로는 근데 a > b > c > d 여야한다고 생각해봐
                //안정적인 순서를 보장하기 위해. 현재 값을 세팅하고 있는 작업을 보장해라.
                //이 데이터 자체를 보장해라
                //res.data.randomNumber 데이터 자체를 states null에 넣는걸 보장해라

                //axious는 url 요청 스프링의 컨트롤러에 요청했어
                //리턴해서 돌아오면 then이 동작 rufrhk res에 있어
                //랜덤넘버만 별도 추출 > state에 들어감
                //view에서 리턴 밸류를 보여주는데 returnValue에 넣어라
                //this.returnValue = this.$store.state.springFromVueTestValue
                //{{returnValue}} 로 출력
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
            .then((res)=> {
                alert(res.data)
                commit()
            })
    },
    requestRandomMonster ({ commit }) {
        console.log("requestGameMonsters()")

        return axios.get('http://localhost:7777/31th/rpg-game/random-monster-lists')
            .then((res) => {
                commit(REQUEST_RANDOM_MONSTER, res.data)
            })
    },
    requestMyInventory ({ commit }) {
        console.log("requestMyInventory()")

        return axios.post('http://localhost:7777/31th/rpg-game/my-inventory')
            .then((res) => {
                commit(REQUEST_MY_INVENTORY, res.data)
            })
    },
    requestCharacterStatus ({ commit }) {
        console.log("requestCharacterStatus()")

        return axios.get('http://localhost:7777/31th/rpg-game/character-status')
            .then((res) => {
                commit(REQUEST_CHARACTER_STATUS, res.data)
            })
    },
}
//스토어에 배치된 action 자바로치면 유틸리티
/*
* 비동기 처리 로직을 선언하는 메소드,
* */