import {
    REQUEST_BOARD_LIST_FROM_SPRING,
    REQUEST_BOARD_READ_FROM_SPRING,
} from './mutation-types'

import axios from "axios";

export default {
    requestBoardListFromSpring ({ commit }) {
        console.log('requestBoardListFromSpring()')

        return axios.get('http://localhost:5555/products-board/lists')
            .then((res) => {
                commit(REQUEST_BOARD_LIST_FROM_SPRING, res.data)
            })
    },

    // eslint-disable-next-line no-empty-pattern
    requestRegisterProductToSpring ({ }, payload) {
        console.log('requestRegisterProductToSpring()')

        const { productName, price, numberInStock, details } = payload
        return axios.post('http://localhost:5555/products-board/register',
            { productName, price, numberInStock, details })
            .then(() => {
                alert('상품 등록 성공')
            })
    },

    requestBoardReadFromSpring ({ commit }, boardNo) {
        console.log('BoardReadFromSpring()'+ boardNo)

        return axios.get(`http://localhost:5555/products-board/${ boardNo }`)
            .then((res) => {
                commit(REQUEST_BOARD_READ_FROM_SPRING, res.data)
            })
    },

    // eslint-disable-next-line no-empty-pattern
    requestProductsBoardModifyToSpring ({ } , payload) {
        console.log('상품 수정')

        const { boardNo, productName, price, numberInStock, details } = payload

        return axios.put(`http://localhost:5555/products-board/${boardNo}`,
            { productName, price, numberInStock, details })
            .then(() => {
                alert('수정 성공')
            })
    },

    // eslint-disable-next-line no-empty-pattern
    requestDeleteProductToSpring ({ }, boardNo) {
        console.log('requestDeleteBoardToSpring()')

        return axios.delete(`http://localhost:5555/products-board/${boardNo}`)
            .then(() => {
                alert('삭제 성공')
            })
    },


}