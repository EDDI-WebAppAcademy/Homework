import {REQUEST_GOODS_FROM_SPRING, REQUEST_GOODS_LIST_FROM_SPRING} from './mutation-types'

export default {
    [REQUEST_GOODS_LIST_FROM_SPRING](state, passingData) {
    state.goodsList = passingData
    },
    [REQUEST_GOODS_FROM_SPRING](state, passingData) {
    state.goods = passingData
    }

}