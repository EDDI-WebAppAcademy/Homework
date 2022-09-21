import {
    REQUEST_BOARD_LIST_FROM_SPRING,
} from './mutation-types'

export default {

    [REQUEST_BOARD_LIST_FROM_SPRING](state, passingData) {
        state.boards = passingData
    },
}