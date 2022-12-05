import {
    REQUEST_PRODUCT_LIST_FROM_SPRING,
    REQUEST_PRODUCT_FROM_SPRING

} from './mutation-types'

//npm install axios --save-dev
import axios from 'axios'

export default {
    requestProductListFromSpring ({ commit }) {
        console.log('requestProductListFromSpring()')

        return axios.get('http://localhost:7777/43th/product/list')
            .then((res) => {
                commit(REQUEST_PRODUCT_LIST_FROM_SPRING, res.data)
            })
    },
    requestProductFromSpring ({ commit }, productNo) {
        console.log('requestProductFromSpring()')

        return axios.get(`http://localhost:7777/43th/product/${productNo}`)
            .then((res) => {
                commit(REQUEST_PRODUCT_FROM_SPRING, res.data)
            })
    },
    // eslint-disable-next-line no-empty-pattern
    requestRegisterProductToSpring ({ }, payload) {
        console.log('requestRegisterProductToSpring()')

        const { productName, productDescription, seller, price } = payload
        return axios.post('http://localhost:7777/43th/product/register',
            { productName, productDescription, seller, price })
            .then(() => {
                alert('상품 등록 성공')
            })
    },
    // eslint-disable-next-line no-empty-pattern
    requestDeleteProductToSpring ({ }, productNo) {
        console.log('requestDeleteProductToSpring()')

        return axios.delete(`http://localhost:7777/43th/product/${productNo}`)
            .then(() => {
                alert('삭제 성공')
            })
    },
    // eslint-disable-next-line no-empty-pattern
    requestModifyProductToSpring ({ }, payload) {
        console.log('requestModifyProductToSpring()')

        const { productNo, productName, seller, price, productDescription, regDate } = payload

        return axios.put(`http://localhost:7777/43th/product/${productNo}`,
            { productName, seller, price, productDescription, regDate })
            .then(() => {
                alert('수정 성공')
            })
    }
}
