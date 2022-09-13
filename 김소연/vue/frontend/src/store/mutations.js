import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_RANDOM_MONSTER,
    REQUEST_MY_INVENTORY,
    REQUEST_CHARACTER_STATUS
} from './mutation-types'

export default {
    [REQUEST_DATA_FROM_SPRING] (state, passingData) {
        state.springFromVueTestValue = passingData
    },
    [REQUEST_RANDOM_SHOP_ITEM] (state, passingData) {
        state.randomShopItem = passingData
    },
    [REQUEST_RANDOM_MONSTER] (state, passingData) {
        state.randomMonster = passingData
    },
    [REQUEST_MY_INVENTORY] (state, passingData) {
        state.myInventory = passingData
    },
    [REQUEST_CHARACTER_STATUS] (state, passingData) {
        state.myInventory = passingData
    }
}

/*
* Vuex의 데이터인 state 값을 변경하는 로직을 의미한다.
* 인자를 받아 Vuex에 넘겨줄 수 있고 computed가 아닌 methods에 등록한다.
* 동기적 로직을 정의할 수 있다.
* => Mutations 의 성격상 안에 정의한 로직들이 순차적으로 일어나야
* 각 컴포넌트의 반영 여부를 제대로 추적할 수가 있기 때문이다.
* */