import {
    REQUEST_BOARD_LIST_FROM_SPRING,
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
}