import {REQUEST_GOODS_FROM_SPRING, REQUEST_GOODS_LIST_FROM_SPRING} from './mutation-types'
import axios from "axios";

// npm install axios --save-dev

export default {
    requestGoodsListFromSpring({commit}) {
        console.log("requestGoodsListFromSpring()")

        return axios.get('http://localhost:7777/goods/list')
            .then((res) => {
                commit(REQUEST_GOODS_LIST_FROM_SPRING, res.data)
            })
    },
    //eslint-disable-next-line no-empty-pattern
    requestRegisterGoodsToSpring({}, payload) {
        console.log("requestRegisterGoodsToSpring()")

        const {goodsName, seller, goodsDescription, price} = payload
        return axios.post('http://localhost:7777/goods/register',
            {goodsName, seller, goodsDescription, price})
            .then(() => {
                alert('상품 등록 성공')
            })
    },
    requestGoodsFromSpring({commit}, goodsNo) {
        console.log('requestGoodsFromSpring()')

        return axios.get(`http://localhost:7777/goods/${goodsNo}`)
            .then((res) => {
                commit(REQUEST_GOODS_FROM_SPRING, res.data)
            })
    },
}